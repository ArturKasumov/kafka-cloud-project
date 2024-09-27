package com.arturk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum CategoryEnum {

    MEAT("Meat"),

    SNACKS("Snacks"),

    VEGETABLES("Vegetables"),

    MILK("Milk");

    private final String categoryName;

    CategoryEnum(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonValue
    public String getCategoryName() {
        return categoryName;
    }

    @JsonCreator
    public static CategoryEnum fromValue(String value) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.categoryName.equals(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
