package com.example.commontest.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class UserEventHandler {

    @EventListener
    public void process(UserEventDto userEventDto){
        log.info("대상자 조회 : {}, 시간 : {}", userEventDto, LocalDateTime.now());
        System.out.println("대상자 조회 : " + userEventDto);
    }

}
