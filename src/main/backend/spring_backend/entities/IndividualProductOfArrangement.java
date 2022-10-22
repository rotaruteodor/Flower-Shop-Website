package spring_backend.entities;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "individual_products_of_arrangements")
public class IndividualProductOfArrangement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = IndividualProduct.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "prdOfArrg_prd_fk")
    private IndividualProduct individualProduct;

    @OneToOne(targetEntity = Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "prdOfArrg_color_fk")
    private Color color;

    @Column(name = "quantity")
    private Integer quantity;

}
