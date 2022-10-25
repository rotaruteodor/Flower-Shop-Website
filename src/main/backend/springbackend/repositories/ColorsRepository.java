package springbackend.repositories;

import springbackend.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<Color, Long> {
}
