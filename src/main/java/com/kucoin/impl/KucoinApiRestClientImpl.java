package com.kucoin.impl;

import com.kucoin.KucoinApiRestClient;
import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;

import java.util.List;

import static com.kucoin.impl.KucoinApiServiceGenerator.executeSync;

/**
 * Implementation of Kucoin's REST API using Retrofit with synchronous/blocking method calls.
 */
public class KucoinApiRestClientImpl implements KucoinApiRestClient {

    private final KucoinApiService kucoinApiService;

    public KucoinApiRestClientImpl(KucoinApiService kucoinApiService) {
        this.kucoinApiService = kucoinApiService;
    }

    // General endpoints

    @Override
    public Response<List<Asset>> getAssets() {
        return executeSync(kucoinApiService.getAssets());
    }

    // Market endpoints

    @Override
    public Response<List<MarketInfo>> getMarketInfo() {
        return executeSync(kucoinApiService.getMarketInfo());
    }
}
