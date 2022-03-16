package com.kucoin;

import com.kucoin.impl.KucoinApiAsyncRestClientImpl;
import com.kucoin.impl.KucoinApiRestClientImpl;
import com.kucoin.impl.KucoinApiService;
import com.kucoin.impl.KucoinApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Kucoin API client objects.
 */
public class KucoinApiClientFactory {

    private final KucoinApiServiceGenerator serviceGenerator;

    public KucoinApiClientFactory() {
        this(new OkHttpClient());
    }

    private KucoinApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new KucoinApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the Kucoin API client factory
     */
    public static KucoinApiClientFactory newInstance() {
        return new KucoinApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public KucoinApiRestClient newRestClient() {
        return new KucoinApiRestClientImpl(serviceGenerator.createService(KucoinApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public KucoinApiAsyncRestClient newAsyncRestClient() {
        return new KucoinApiAsyncRestClientImpl(serviceGenerator.createService(KucoinApiService.class));
    }
}
