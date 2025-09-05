package com.janlevy.repository;

import com.janlevy.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Zapouzdreni pristupu k databazi
 */
@ApplicationScoped
public class TransactionRepository {

    @Inject
    EntityManager em;

    /**
     * Vrati vsechny transakce pro dane cislo uctu
     * @param ownAccountNumber
     * @return
     */
    public List<Transaction> findByOwnAccountNumber(String ownAccountNumber) {
        TypedQuery<Transaction> q = em.createQuery(
                "SELECT t FROM Transaction t " +
                        "WHERE t.ownAccountNumber = :ownAccountNumber " +
                        "ORDER BY t.postingDate DESC, t.trxId DESC",
                Transaction.class
        );
        q.setParameter("ownAccountNumber", ownAccountNumber);
        return q.getResultList();
    }
}