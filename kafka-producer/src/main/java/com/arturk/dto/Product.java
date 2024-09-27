package com.arturk.dto;

import com.arturk.enums.CategoryEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private CategoryEnum category;
    private String productName;
    private int quantity;
}
