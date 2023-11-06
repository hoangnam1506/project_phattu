package com.example.jpaIntern.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Product_Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productReviewID;
    @Column
    private String contentRated;
    @Column
    private int pointEvaluation;
    @Column
    private String contentSeen;
    @Column
    private int status;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    private User user;

    public int getProductReviewID() {
        return productReviewID;
    }

    public void setProductReviewID(int productReviewID) {
        this.productReviewID = productReviewID;
    }

    public String getContentRated() {
        return contentRated;
    }

    public void setContentRated(String contentRated) {
        this.contentRated = contentRated;
    }

    public int getPointEvaluation() {
        return pointEvaluation;
    }

    public void setPointEvaluation(int pointEvaluation) {
        this.pointEvaluation = pointEvaluation;
    }

    public String getContentSeen() {
        return contentSeen;
    }

    public void setContentSeen(String contentSeen) {
        this.contentSeen = contentSeen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
