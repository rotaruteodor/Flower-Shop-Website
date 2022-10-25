package springbackend.repositories;

import springbackend.entities.FlowerArrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerArrangementsRepository extends JpaRepository<FlowerArrangement, Long> {
}
