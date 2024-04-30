package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "product_details")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "This is product model")
public class ProductDetails {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expiration;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price;

    @Getter
    @Column(name = "available")
    private boolean availablility;

    @JsonIgnore
    @OneToOne(mappedBy="productDetails",cascade = CascadeType.ALL)
    Product product;

}
