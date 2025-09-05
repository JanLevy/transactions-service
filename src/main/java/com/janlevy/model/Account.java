package com.janlevy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Mapovani uctu
 */
@Getter
@Setter
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountId", nullable = false, updatable = false)
    private long accountId;
    @Column(name="name", length = 50, nullable = false)
    private String accountName;
    @Column(name="number", length = 20, nullable = false)
    private String accountNumber;
    @Column(name="code", length = 4, nullable = false)
    private String bankCode;
}
