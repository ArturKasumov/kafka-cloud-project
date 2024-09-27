package com.arturk.entity;

import com.arturk.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @SequenceGenerator(name = "product_id_generator", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
    @GeneratedValue(generator = "product_id_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CATEGORY")
    @Enumerated(value = EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "QUANTITY")
    private int quantity;
}
