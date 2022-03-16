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
    private Boolean enabled;

    @JsonProperty("isMarginEnabled")
    private Boolean marginEnabled;

    private String feeCurrency;

    private Double baseMinSize;
    private Double quoteMinSize;
    private Double baseMaxSize;
    private Double quoteMaxSize;
    private Double baseIncrement;
    private Double quoteIncrement;
    private Double priceIncrement;
    private Double priceLimitRate;
    private Double minFunds;

}
