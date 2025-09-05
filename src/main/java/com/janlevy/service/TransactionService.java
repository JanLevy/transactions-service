package com.janlevy.service;

import com.janlevy.model.Transaction;
import com.janlevy.repository.TransactionRepository;
import com.janlevy.web.TransactionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 * Servisa pro zpracovani dotazu na transakce
 */
@ApplicationScoped
public class TransactionService {

    @Inject
    TransactionRepository transactionRepository;

    /**
     * Vrati vsechny transakce pro dane cislo uctu namapovane na response objekty
     * @param ownAccountNumber
     * @return
     */
    public List<TransactionResponse> findByOwnAccountNumber(String ownAccountNumber) {
        // ownAccountNumber je ulozeno jako varchar / String -> neoveruju, ze je to int, muze mi prijit cokoliv
        // kdyz nenajdu v db zadny odpovidajici zaznam, vratim prazdny seznam
        List<Transaction> results = transactionRepository.findByOwnAccountNumber(ownAccountNumber);
        return results.stream().map(TransactionResponse::fromTransaction).toList();
    }
}
