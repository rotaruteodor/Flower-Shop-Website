package springbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbackend.entities.enums.FlowerArrangementType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(targetEntity = FlowerArrangementComponent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_arrangement_id")
    private List<FlowerArrangementComponent> components;

}

