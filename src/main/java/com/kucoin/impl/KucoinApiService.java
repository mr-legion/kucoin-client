package com.kucoin.impl;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;
import com.kucoin.domain.market.MarketTickerResponse;
import com.kucoin.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Kucoin's REST API URL mappings.
 */
public interface KucoinApiService {

    // General endpoints

    @GET("/api/v1/currencies")
    Call<Response<List<Asset>>> getAssets();

    // Market endpoints

    @GET("/api/v1/symbols")
    Call<Response<List<MarketInfo>>> getMarketInfo();

    @GET("/api/v1/market/allTickers")
    Call<Response<MarketTickerResponse>> getMarketTickers();

    @GET("/api/v1/market/orderbook/level2_{limit}")
    Call<Response<OrderBook>> getOrderBook(@Path("limit") Integer limit, @Query("symbol") String symbol);

}
