package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome é obbligatorio")
    @Size(max = 100, message = "Il nome puó contenere massimo 100 caratteri")
    private String name;

    @Lob
    @Size(min = 10, max = 500, message = "La descrizione deve contenere tra 10 e 500 caratteri")
    private String description;

    @NotBlank(message = "URL Obbligatorio")
    @URL(message = "Inserisci un URL valido")
    private String url;

    @NotNull(message = "Inserisci un prezzo")
    @Positive(message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal price;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString() {
        return String.format(
                "La pizza col nome %s \n Id numero: %d \n Prezzo %s \n Url: %s \n Descrizione della pizza: %s",
                this.name, this.id, this.price, this.url, this.description);
    }

}
