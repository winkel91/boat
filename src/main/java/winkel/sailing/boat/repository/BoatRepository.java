package winkel.sailing.boat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import winkel.sailing.boat.model.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
}

