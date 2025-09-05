package com.janlevy.model;

import com.janlevy.enums.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Mapovani transakce
 */
@Getter
@Setter
@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trxId", nullable = false, updatable = false)
    private long trxId;

    @Column(name="amount", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name="currency", length = 3, nullable = false)
    private Currency currency;

    @Column(name="id", length = 20, nullable = false)
    private String id;

    @Column(name="bankref", length = 20, nullable = false)
    private String bankref;

    @Column(name="transactionId", length = 20, nullable = false)
    private String transactionId;

    @Column(name="bookingDate")
    private LocalDate bookingDate;

    @Column(name="postingDate", nullable = false)
    private LocalDate postingDate;

    @Column(name="creditDebitIndicator", length = 4)
    private String creditDebitIndicator;

    @Column(name="ownAccountNumber", length = 20)
    private String ownAccountNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "counterPartyAccount", nullable = false)
    private Account counterPartyAccount;

    @Column(name="detail1", length = 50)
    private String detail1;

    @Column(name="detail2", length = 50)
    private String detail2;

    @Column(name="detail3", length = 50)
    private String detail3;

    @Column(name="detail4", length = 50)
    private String detail4;

    @Column(name="productBankRef", length = 50)
    private String productBankRef;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transactionType", nullable = false)
    private TransactionType transactionType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "statement", nullable = false)
    private com.janlevy.model.Statement statement;

    @Column(name="constantSymbol", length = 10)
    private String constantSymbol;

    @Column(name="specificSymbol", length = 10)
    private String specificSymbol;

    @Column(name="variableSymbol", length = 10)
    private String variableSymbol;
}