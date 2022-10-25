package springbackend.entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "flower_arrangement_components")
public class FlowerArrangementComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = FlowerArrangementComponentGeneralInfo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flwr_arrg_component_general_info_id")
    private FlowerArrangementComponentGeneralInfo flowerArrangementComponentGeneralInfo;

    @ManyToOne(targetEntity = Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "quantity")
    private Long quantity;
}
