package com.example.jpaIntern.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Decentrazilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int decentrazilationID;
    @Column
    private String authorityName;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "decentrazilation")
    @JsonIgnore
    private List<Account> accounts;

    public int getDecentrazilationID() {
        return decentrazilationID;
    }

    public void setDecentrazilationID(int decentrazilationID) {
        this.decentrazilationID = decentrazilationID;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
