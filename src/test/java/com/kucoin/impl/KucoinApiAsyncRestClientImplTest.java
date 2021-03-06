package com.kucoin.impl;

import com.kucoin.KucoinApiAsyncRestClient;
import com.kucoin.KucoinApiClientFactory;
import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import com.kucoin.domain.market.MarketInfo;
import com.kucoin.domain.market.MarketTickerResponse;
import com.kucoin.domain.market.OrderBook;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KucoinApiAsyncRestClientImplTest {

    private final KucoinApiAsyncRestClient kucoinApiAsyncRestClient = KucoinApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<List<Asset>> response = kucoinApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        Response<List<MarketInfo>> response = kucoinApiAsyncRestClient.getMarketInfo().get();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() throws ExecutionException, InterruptedException {
        Response<MarketTickerResponse> response = kucoinApiAsyncRestClient.getMarketTickers().get();
        assertNotNull(response);
        assertThat(response.getData().getTickers(), is(not(empty())));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() throws ExecutionException, InterruptedException {
        Response<OrderBook> response = kucoinApiAsyncRestClient.getOrderBook("BTC-USDT", 20).get();
        assertNotNull(response);
        assertThat(response.getData().getAsks(), is(not(empty())));
        assertThat(response.getData().getBids(), is(not(empty())));
    }
}