package com.kucoin.impl;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;
import retrofit2.Call;
import retrofit2.http.GET;

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

}
