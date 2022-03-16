package com.kucoin;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;

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

}