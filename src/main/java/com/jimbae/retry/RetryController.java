package com.jimbae.retry;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RetryController {

    private final RetryService retryService;

    @GetMapping("/image/{id}")
    public ResponseEntity<String> ok(@PathVariable Long id) {
        return ResponseEntity.ok(retryService.image(id));
    }

}
