package com.kucoin.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * Market ticker wrapper.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTickerResponse {

    @JsonProperty("ticker")
    private List<MarketTicker> tickers;

    private long time;

}
