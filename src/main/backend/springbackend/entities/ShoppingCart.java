package springbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = ShoppingCartFlowerArrangement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private List<ShoppingCartFlowerArrangement> shoppingCartFlowerArrangements;

}
