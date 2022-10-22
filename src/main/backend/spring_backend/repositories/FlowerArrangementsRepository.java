package spring_backend.repositories;

import spring_backend.entities.FlowerArrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerArrangementsRepository extends JpaRepository<FlowerArrangement, Long> {
}
