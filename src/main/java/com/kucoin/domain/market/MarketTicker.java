package com.kucoin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private String symbol;

    @JsonProperty("symbolName")
    private String name;

    private Double last;
    private Double averagePrice;

    @JsonProperty("sell")
    private Double ask;

    @JsonProperty("buy")
    private Double bid;

    private Double low;
    private Double high;

    private Double vol;
    private Double volValue;

    private Double changeRate;
    private Double changePrice;

    private Double takerFeeRate;
    private Double makerFeeRate;

    private int takerCoefficient;
    private int makerCoefficient;

}
