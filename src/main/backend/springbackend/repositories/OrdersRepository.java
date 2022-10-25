package springbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springbackend.entities.Order;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM orders o WHERE o.user_id = :userId")
    List<Order> findByUserId(Long userId);
}
