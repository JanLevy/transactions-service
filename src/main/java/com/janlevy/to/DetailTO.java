package com.janlevy.to;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DetailTO(String detail1, String detail2, String detail3, String detail4) {
}
