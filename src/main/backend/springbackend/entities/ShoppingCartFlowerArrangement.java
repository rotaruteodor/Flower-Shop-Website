package springbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shopping_cart_flower_arrangements")
public class ShoppingCartFlowerArrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = FlowerArrangement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_arrangement_id")
    private FlowerArrangement flowerArrangement;

    @OneToOne(targetEntity = ShoppingCart.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Column(name = "quantity")
    private Long quantity;
}
