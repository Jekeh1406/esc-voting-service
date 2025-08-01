package com.escvoting.country;
import jakarta.persistence.*;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}