package com.janlevy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Mapovani typu transakce
 */
@Getter
@Setter
@Entity
@Table(name="transactionType")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trxTypeId", nullable = false, updatable = false)
    private long transactionTypeId;
    @Column(name="type", length = 20, nullable = false)
    private String transactionType;
    @Column(name="code", nullable = false)
    private int transactionCode;
}
