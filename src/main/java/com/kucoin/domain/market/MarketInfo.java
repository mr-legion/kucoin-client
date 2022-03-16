package com.kucoin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String symbol;
    private String name;

    @JsonProperty("baseCurrency")
    private String baseAsset;

    @JsonProperty("quoteCurrency")
    private String quoteAsset;

    private String market;

    @JsonProperty("enableTrading")
    private boolean enabled;

    @JsonProperty("isMarginEnabled")
    private boolean marginEnabled;

    private String feeCurrency;

    private double baseMinSize;
    private double quoteMinSize;
    private double baseMaxSize;
    private double quoteMaxSize;
    private double baseIncrement;
    private double quoteIncrement;
    private double priceIncrement;
    private double priceLimitRate;
    private double minFunds;

}
