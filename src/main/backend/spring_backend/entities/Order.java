package spring_backend.entities;

import spring_backend.entities.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany(targetEntity = FlowerArrangement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_arrangements_fk")
    private List<FlowerArrangement> flowerArrangements;


}
