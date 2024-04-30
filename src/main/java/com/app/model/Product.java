package com.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@ApiModel(value = "This is product model")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public Product(int id) {
        this.id = id;
    }

    @ApiModelProperty(value = "Product Name")
    @Column(name = "name")
    private String name;


    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;

//    public Product(String productName) {
//        this.productName = productName;
//    }

    public Product(String productName) {
        this.name = productName;

    }
}
