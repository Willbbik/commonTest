package com.example.commontest.eventlistener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private ApplicationEventPublisher eventPublisher;

    private UserService userService;

    @Mock
    private UserEventHandler userEventHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(eventPublisher);
    }

    @Test
    void get() {
        //given
        String userId = "test";

        //when
        UserInfo userInfo = userService.get(userId);

        //then
        assertEquals(userId, userInfo.getUserId());
        assertEquals("이름", userInfo.getName());
        assertEquals("21", userInfo.getAge());
    }


}