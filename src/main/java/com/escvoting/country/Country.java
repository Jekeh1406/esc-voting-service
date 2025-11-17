package com.escvoting.country;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    int id;
    String code;
    String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Country() {

    }
}