package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class InternOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;
    @Column
    private double originalPrice;
    @Column
    private double actualPrice;
    @Column
    private String fullName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    @JsonIgnore
    private List<Order_Detail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "OrdersStatusID")
    private Order_Status orderStatus;
    @ManyToOne
    @JoinColumn(name = "paymentID")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Order_Detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order_Detail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order_Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Order_Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
