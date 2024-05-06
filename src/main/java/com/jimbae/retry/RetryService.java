package com.jimbae.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryService {

    @Retryable(
        retryFor = {RuntimeException.class},
        backoff = @Backoff(delay = 1000), //1초 후 재시도
        maxAttempts = 3,
        listeners = {"catImageListener"}//신기하네.. 이거
    )
    public String image(Long id) {
        //return "image.jpg";
        throw new RuntimeException("image 호출 실패");
    }

    //위의 image 메소드가 3번 시도 후 실패하면 아래의 메소드를 호출한다.
    //여러 메서드 구현 시 Retryable 쪽에서 직접적으로 fallback 용 메서드 이름 설정 가능
    @Recover
    public String imageFallback(RuntimeException e, Long id) {
        log.info("fallback 호출: {}", e);
        return "default_image.jpg";
    }
}
