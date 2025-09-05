package com.janlevy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Mapovani vypisu
 */
@Getter
@Setter
@Entity
@Table(name="statement")
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="statementId", nullable = false, updatable = false)
    private long statementId;
    @Column(name="number", length = 20, nullable = false)
    private String number;
    @Column(name="period", length = 20, nullable = false)
    private String period;
    @Column(name="description", length = 1000)
    private String description;
}
