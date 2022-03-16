package com.kucoin;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;
import com.kucoin.domain.market.MarketTickerResponse;

import java.util.List;

/**
 * Kucoin API facade, supporting synchronous/blocking access Kucoin's REST API.
 */
public interface KucoinApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<List<Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Response<List<MarketInfo>> getMarketInfo();

    /**
     * Get market tickers information.
     *
     * @return market tickers
     */
    Response<MarketTickerResponse> getMarketTickers();

}