package com.jimbae.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.stereotype.Component;

@Component("catImageListener")
@Slf4j
public class CatImageListener implements RetryListener {

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context,
        RetryCallback<T, E> callback) {
        log.info("RetryListener open");
        return true;
    }

    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
        Throwable throwable) {
        log.info("RetryListener close");
    }

    @Override
    public <T, E extends Throwable> void onSuccess(RetryContext context,
        RetryCallback<T, E> callback, T result) {
        log.info("RetryListener onSuccess");
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
        Throwable throwable) {
        log.info("RetryListener onError");
    }
}
