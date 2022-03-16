package com.kucoin;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;
import com.kucoin.domain.market.MarketTickerResponse;
import com.kucoin.domain.market.OrderBook;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Kucoin API facade, supporting asynchronous/non-blocking access Kucoin's REST API.
 */
public interface KucoinApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<List<Asset>>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Response<List<MarketInfo>>> getMarketInfo();

    /**
     * Get market tickers information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<MarketTickerResponse>> getMarketTickers();

    /**
     * Get order book for the market (asynchronous).
     *
     * @param symbol market symbol (e.g. BTC-USDT)
     * @param limit  depth of the order book. Valid limits: [20, 100]
     * @return orderbook
     */
    CompletableFuture<Response<OrderBook>> getOrderBook(String symbol, Integer limit);

}