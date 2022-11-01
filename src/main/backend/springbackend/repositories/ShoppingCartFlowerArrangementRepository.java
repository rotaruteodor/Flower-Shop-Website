package springbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import springbackend.dto.ShoppingCartFlowerArrangementDto;
import springbackend.entities.ShoppingCartFlowerArrangement;

import javax.transaction.Transactional;

@Transactional
public interface ShoppingCartFlowerArrangementRepository extends JpaRepository<ShoppingCartFlowerArrangement, Long> {

    @Modifying
    @Query("UPDATE ShoppingCartFlowerArrangement scfa SET scfa.quantity = :quantity WHERE scfa.id = :id")
    int updateQuantity(@Param("id") Long id, @Param("quantity") Long quantity);
}
