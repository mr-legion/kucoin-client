package com.kucoin.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Asset description.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("currency")
    private String symbol;

    private String name;
    private String fullName;

    @JsonProperty("isMarginEnabled")
    private Boolean marginEnabled;

    @JsonProperty("isDebitEnabled")
    private Boolean debitEnabled;

    @JsonProperty("isDepositEnabled")
    private Boolean depositEnabled;

    @JsonProperty("isWithdrawEnabled")
    private Boolean withdrawEnabled;

    @JsonProperty("withdrawalMinFee")
    private Double withdrawFee;

    @JsonProperty("withdrawalMinSize")
    private Double withdrawalMinSize;
    private Integer precision;

    @JsonProperty("confirms")
    private Integer minConfirm;

    private String contractAddress;

}