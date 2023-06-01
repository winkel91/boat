package winkel.sailing.race.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import winkel.sailing.race.model.Race;
import winkel.sailing.race.respository.RaceRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Long id) {
        Optional<Race> race = raceRepository.findById(id);
        return race.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Race createRace(@RequestBody Race race) {
        return raceRepository.save(race);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race raceData) {
        Optional<Race> optionalRace = raceRepository.findById(id);
        if (optionalRace.isPresent()) {
            Race race = optionalRace.get();
            race.setDate(raceData.getDate());
            race.setPlacement(raceData.getPlacement());
            return ResponseEntity.ok(raceRepository.save(race));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        Optional<Race> optionalRace = raceRepository.findById(id);
        if (optionalRace.isPresent()) {
            raceRepository.delete(optionalRace.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
