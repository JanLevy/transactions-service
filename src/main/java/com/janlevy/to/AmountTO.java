package com.janlevy.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.janlevy.enums.Currency;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AmountTO(Currency currency, BigDecimal amount) {
}
