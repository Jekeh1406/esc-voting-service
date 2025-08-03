package com.escvoting.country;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    String code;
    String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country() {

    }
}