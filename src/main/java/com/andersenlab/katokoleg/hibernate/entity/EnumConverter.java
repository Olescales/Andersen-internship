package com.andersenlab.katokoleg.hibernate.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role.name();
    }

    @Override
    public Role convertToEntityAttribute(String strRole) {
        for (Role role : Role.values()) {
            if (role.name().equals(strRole)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + strRole);
    }
}
