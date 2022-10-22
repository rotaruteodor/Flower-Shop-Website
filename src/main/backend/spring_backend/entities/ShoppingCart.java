package spring_backend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = FlowerArrangement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_arrangements_fk")
    private List<FlowerArrangement> flowerArrangements;
}
