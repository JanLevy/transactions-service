package com.janlevy.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.janlevy.model.Transaction;
import com.janlevy.to.AccountTO;
import com.janlevy.to.AmountTO;
import com.janlevy.to.DetailTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Trida obalujici odpoved na zaslany dotaz na transakce
 */
@AllArgsConstructor
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionResponse {

    @JsonProperty("amount")
    private AmountTO amount;

    @JsonProperty("bankref")
    private String bankref;

    @JsonProperty("bookingDate")
    private LocalDate bookingDate;

    @JsonProperty("counterPartyAccount")
    private AccountTO counterPartyAccount;

    @JsonProperty("creditDebitIndicator")
    private String creditDebitIndicator;

    @JsonProperty("details")
    private DetailTO details;

    @JsonProperty("id")
    private String id;

    @JsonProperty("ownAccountNumber")
    private String ownAccountNumber;

    @JsonProperty("postingDate")
    private LocalDate postingDate;

    @JsonProperty("productBankRef")
    private String productBankRef;

    @JsonProperty("specificSymbol")
    private String specificSymbol;

    @JsonProperty("statementNumber")
    private String statementNumber;

    @JsonProperty("statementPeriod")
    private String statementPeriod;

    @JsonProperty("transactionId")
    private long transactionId;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("transactionTypeCode")
    private int transactionTypeCode;

    @JsonProperty("variableSymbol")
    private String variableSymbol;

    /**
     * Namapuje predanou transakci na response objekt.
     * @param transaction
     * @return
     */
    public static TransactionResponse fromTransaction(Transaction transaction) {
        return new TransactionResponse(
                new AmountTO(transaction.getCurrency(), transaction.getAmount()),
                transaction.getBankref(),
                transaction.getBookingDate(),
                // transaction.counterPartyAccount neni nullable, neoveruju nenullovost
                new AccountTO(transaction.getCounterPartyAccount().getAccountName(),
                        transaction.getCounterPartyAccount().getAccountNumber(),
                        transaction.getCounterPartyAccount().getBankCode()),
                transaction.getCreditDebitIndicator(),
                new DetailTO(transaction.getDetail1(), transaction.getDetail2(), transaction.getDetail3(), transaction.getDetail4()),
                transaction.getId(),
                transaction.getOwnAccountNumber(),
                transaction.getPostingDate(),
                transaction.getProductBankRef(),
                transaction.getSpecificSymbol(),
                // transaction.statement neni nullable, neoveruju nenullovost
                transaction.getStatement().getNumber(),
                transaction.getStatement().getPeriod(),
                transaction.getTrxId(),
                // transaction.transactionType neni nullable, neoveruju nenullovost
                transaction.getTransactionType().getTransactionType(),
                transaction.getTransactionType().getTransactionCode(),
                transaction.getVariableSymbol());
    }
}
