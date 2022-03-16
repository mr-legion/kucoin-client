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
    private boolean marginEnabled;

    @JsonProperty("isDebitEnabled")
    private boolean debitEnabled;

    @JsonProperty("isDepositEnabled")
    private boolean depositEnabled;

    @JsonProperty("isWithdrawEnabled")
    private boolean withdrawEnabled;

    @JsonProperty("withdrawalMinFee")
    private double withdrawFee;

    @JsonProperty("withdrawalMinSize")
    private double withdrawalMinSize;
    private int precision;

    @JsonProperty("confirms")
    private int minConfirm;

    private String contractAddress;

}