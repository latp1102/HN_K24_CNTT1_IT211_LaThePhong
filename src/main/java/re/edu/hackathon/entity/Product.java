package re.edu.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;
import re.edu.hackathon.common.Status;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String sku;
    private String description;
    private String stockQuantity;
    private Double price;
    private String category;
    private String weight;
    private String image;
    @Enumerated(EnumType.STRING)
    private Status status;
}
