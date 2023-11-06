package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity @Table
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CartsID;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private User user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carts")
    @JsonIgnore
    private List<Carts_Items> cartsItems;

    public int getCartsID() {
        return CartsID;
    }

    public void setCartsID(int cartsID) {
        CartsID = cartsID;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Carts_Items> getCartsItems() {
        return cartsItems;
    }

    public void setCartsItems(List<Carts_Items> cartsItems) {
        this.cartsItems = cartsItems;
    }
}
