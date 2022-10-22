package spring_backend.repositories;

import spring_backend.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartsRepository extends JpaRepository<ShoppingCart, Long> {
}
