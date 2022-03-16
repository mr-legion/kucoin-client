package com.kucoin.impl;

import com.kucoin.KucoinApiError;
import com.kucoin.exception.KucoinApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static com.kucoin.constant.KucoinApiConstants.API_BASE_URL;

/**
 * Generates a Kucoin API implementation based on @see {@link KucoinApiService}.
 */
public class KucoinApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, KucoinApiError> errorBodyConverter =
            (Converter<ResponseBody, KucoinApiError>) converterFactory.responseBodyConverter(
                    KucoinApiError.class, new Annotation[0], null);

    private final OkHttpClient client;

    public KucoinApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                KucoinApiError apiError = getKucoinApiError(response);
                throw new KucoinApiException(apiError);
            }
        } catch (IOException e) {
            throw new KucoinApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static KucoinApiError getKucoinApiError(Response<?> response) throws IOException, KucoinApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

}
