package com.f1rst.registryapi.ddd.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeClientEnum {
    PF("PF"),
    PJ("PJ");

    private final String value;

    TypeClientEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TypeClientEnum fromString(String value) {
        for (TypeClientEnum type : TypeClientEnum.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TypeClientEnum: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

