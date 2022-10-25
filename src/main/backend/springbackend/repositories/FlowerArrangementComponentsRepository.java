package springbackend.repositories;

import springbackend.entities.FlowerArrangementComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerArrangementComponentsRepository extends JpaRepository<FlowerArrangementComponent, Long> {
}
