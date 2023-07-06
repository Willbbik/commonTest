package com.example.commontest.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserInfo get(final String userId) {
        applicationEventPublisher.publishEvent(new UserEventDto(userId));

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setName("이름");
        userInfo.setAge("21");
        return userInfo;
    }

}
