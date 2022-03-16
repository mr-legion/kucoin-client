package com.kucoin.impl;

import com.kucoin.KucoinApiClientFactory;
import com.kucoin.KucoinApiRestClient;
import com.kucoin.domain.Response;
import com.kucoin.domain.general.Asset;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KucoinApiRestClientImplTest {

    private final KucoinApiRestClient kucoinApiRestClient = KucoinApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<List<Asset>> response = kucoinApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), is(not(empty())));
    }
}