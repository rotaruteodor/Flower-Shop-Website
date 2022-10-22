package spring_backend.entities;

import spring_backend.entities.enums.FlowerArrangementType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "flower_arrangements")
public class FlowerArrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FlowerArrangementType type;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(targetEntity = IndividualProductOfArrangement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "arrangement_productsOfArrangements_fk")
    private List<IndividualProductOfArrangement> contents;

}
