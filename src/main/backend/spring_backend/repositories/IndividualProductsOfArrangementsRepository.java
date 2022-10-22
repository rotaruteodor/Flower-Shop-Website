package spring_backend.repositories;

import spring_backend.entities.IndividualProductOfArrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualProductsOfArrangementsRepository extends JpaRepository<IndividualProductOfArrangement, Long> {
}
