package winkel.sailing.race.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winkel.sailing.race.model.Race;
import winkel.sailing.race.respository.RaceRepository;

import java.util.List;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public Race addRace(Race race) {
        return raceRepository.save(race);
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }}