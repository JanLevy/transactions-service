package com.janlevy.api;

import com.janlevy.service.TransactionService;
import com.janlevy.web.TransactionResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * Trida pro namapovani requestu na transakce uctu klienta
 */
@ApplicationScoped
@Path("/accounts/{ownAccountNumber}/transactions")
@Produces(MediaType.APPLICATION_JSON)
public class AccountTransactionsResource {

    @Inject
    TransactionService transactionService;

    @GET
    public List<TransactionResponse> listTransactions(
            @PathParam("ownAccountNumber") String ownAccountNumber
    ) {
        return transactionService.findByOwnAccountNumber(ownAccountNumber);
    }
}
