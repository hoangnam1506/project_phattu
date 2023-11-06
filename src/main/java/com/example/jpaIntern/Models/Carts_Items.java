package com.example.jpaIntern.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Carts_Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CartsItemID;
    @Column
    private int quantity;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CartsID")
    private Carts carts;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private Product product;

    public int getCartsItemID() {
        return CartsItemID;
    }

    public void setCartsItemID(int cartsItemID) {
        CartsItemID = cartsItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Carts getCarts() {
        return carts;
    }

    public void setCarts(Carts carts) {
        this.carts = carts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
