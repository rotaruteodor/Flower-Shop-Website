package spring_backend.repositories;

import spring_backend.entities.IndividualProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualProductsRepository extends JpaRepository<IndividualProduct, Long> {
}
