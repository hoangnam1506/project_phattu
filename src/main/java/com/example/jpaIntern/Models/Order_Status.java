package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Order_Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrdersStatusID;
    @Column
    private String statusName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderStatus")
    @JsonIgnore
    private List<InternOrder> orders;

    public List<InternOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<InternOrder> orders) {
        this.orders = orders;
    }

    public int getOrdersStatusID() {
        return OrdersStatusID;
    }

    public void setOrdersStatusID(int ordersStatusID) {
        OrdersStatusID = ordersStatusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}
