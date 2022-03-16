package com.kucoin.impl;

import com.kucoin.KucoinApiError;
import com.kucoin.exception.KucoinApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.kucoin.impl.KucoinApiServiceGenerator.getKucoinApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                KucoinApiError apiError = getKucoinApiError(response);
                onFailure(call, new KucoinApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new KucoinApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof KucoinApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new KucoinApiException(t));
        }
    }
}
