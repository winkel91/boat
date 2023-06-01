package winkel.sailing.boat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winkel.sailing.boat.model.Boat;
import winkel.sailing.boat.repository.BoatRepository;

import java.util.List;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public Boat addBoat(Boat course) {
        return boatRepository.save(course);
    }

    public List<Boat> getAllBoats() {
        return boatRepository.findAll();
    }}
