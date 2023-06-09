package winkel.sailing.boat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import winkel.sailing.boat.model.Boat;
import winkel.sailing.boat.repository.BoatRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/boats")
public class BoatController {
    private final BoatRepository boatRepository;

    public BoatController(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    @GetMapping
    public List<Boat> getAllBoats() {
        List<Boat> boats = boatRepository.findAll();
        boats.sort(Comparator.comparingInt(Boat::getPoints));
        return boats;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boat> getBoatById(@PathVariable Long id) {
        Optional<Boat> boat = boatRepository.findById(id);
        return boat.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Boat createBoat(@RequestBody Boat boat) {
        return boatRepository.save(boat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boat> updateBoat(@PathVariable Long id, @RequestBody Boat boatData) {
        Optional<Boat> optionalBoat = boatRepository.findById(id);
        if (optionalBoat.isPresent()) {
            Boat boat = optionalBoat.get();
            boat.setName(boatData.getName());
            boat.setLengthClass(boatData.getLengthClass());
            boat.setPoints(boatData.getPoints());
            return ResponseEntity.ok(boatRepository.save(boat));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable Long id) {
        Optional<Boat> optionalBoat = boatRepository.findById(id);
        if (optionalBoat.isPresent()) {
            boatRepository.delete(optionalBoat.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{id}/giftPoints")
    public ResponseEntity<String> giftPoints(@PathVariable Long id, @RequestParam("placement") int placement) {
        Optional<Boat> optionalBoat = boatRepository.findById(id);
        if (optionalBoat.isPresent()) {
            Boat boat = optionalBoat.get();
            int points = placement; // Assign points based on placement

            // Update boat points
            boat.setPoints(points);
            boatRepository.save(boat);

            return ResponseEntity.ok("Points gifted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}