package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    @Column
    private String avatar;
    @Column
    private String accountName;
    @Column
    private String resetPasswordToken;
    @Column
    private LocalDate resetPasswordTokenExpiry;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @JsonIgnore
    private List<User> users ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decentrazilationID")
    private Decentrazilation decentrazilation;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public LocalDate getResetPasswordTokenExpiry() {
        return resetPasswordTokenExpiry;
    }

    public void setResetPasswordTokenExpiry(LocalDate resetPasswordTokenExpiry) {
        this.resetPasswordTokenExpiry = resetPasswordTokenExpiry;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Decentrazilation getDecentrazilation() {
        return decentrazilation;
    }

    public void setDecentrazilation(Decentrazilation decentrazilation) {
        this.decentrazilation = decentrazilation;
    }
}
