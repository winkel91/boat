package winkel.sailing.race.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import winkel.sailing.race.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
