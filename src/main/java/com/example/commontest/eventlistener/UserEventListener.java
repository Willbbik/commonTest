package com.example.commontest.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class UserEventListener {

    @Async
    @EventListener
    public void process(UserEventDto userEventDto) throws InterruptedException {
        Thread.sleep(2000);  //2초
        log.info("대상자 조회 : {}", userEventDto);
    }

    @Async
    @EventListener
    public void process2(UserEventDto userEventDto) throws InterruptedException {
        Thread.sleep(3000);  //3초
        log.info("시간 : {}", LocalDateTime.now());
    }

}
