package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @Column
    private String nameProduct;
    @Column
    private Double price;
    @Column
    private String AIProduct;//Avatar Image
    @Column
    private String title;
    @Column
    private int discount;
    @Column
    private int status;
    @Column
    private int numOfViews;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<Product_Images> productImages;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<Order_Detail> orderDetails;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<Product_Reviews> productReviews;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private List<Carts_Items> cartsItems;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productTypeID")
    private Product_Types productTypes;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAIProduct() {
        return AIProduct;
    }

    public void setAIProduct(String AIProduct) {
        this.AIProduct = AIProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumOfViews() {
        return numOfViews;
    }

    public void setNumOfViews(int numOfViews) {
        this.numOfViews = numOfViews;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }

    public List<Product_Images> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Product_Images> productImages) {
        this.productImages = productImages;
    }

    public List<Order_Detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order_Detail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Product_Reviews> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(List<Product_Reviews> productReviews) {
        this.productReviews = productReviews;
    }

    public List<Carts_Items> getCartsItems() {
        return cartsItems;
    }

    public void setCartsItems(List<Carts_Items> cartsItems) {
        this.cartsItems = cartsItems;
    }

    public Product_Types getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Product_Types productTypes) {
        this.productTypes = productTypes;
    }
}
