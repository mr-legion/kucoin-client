package com.kucoin;

import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;

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

}