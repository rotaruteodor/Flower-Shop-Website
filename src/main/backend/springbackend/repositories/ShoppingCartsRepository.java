package springbackend.repositories;

import springbackend.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartsRepository extends JpaRepository<ShoppingCart, Long> {
}
