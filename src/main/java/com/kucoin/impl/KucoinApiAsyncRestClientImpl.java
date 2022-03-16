package com.kucoin.impl;

import com.kucoin.KucoinApiAsyncRestClient;
import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Kucoin's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class KucoinApiAsyncRestClientImpl implements KucoinApiAsyncRestClient {

    private final KucoinApiService kucoinApiService;

    public KucoinApiAsyncRestClientImpl(KucoinApiService kucoinApiService) {
        this.kucoinApiService = kucoinApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<List<Asset>>> getAssets() {
        CompletableFuture<Response<List<Asset>>> future = new CompletableFuture<>();
        kucoinApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<Response<List<MarketInfo>>> getMarketInfo() {
        CompletableFuture<Response<List<MarketInfo>>> future = new CompletableFuture<>();
        kucoinApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
