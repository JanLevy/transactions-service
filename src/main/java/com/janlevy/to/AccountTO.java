package com.janlevy.to;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AccountTO(String accountName, String accountNumber, String bankCode) {}
