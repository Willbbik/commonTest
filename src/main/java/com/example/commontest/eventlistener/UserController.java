package com.example.commontest.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/event-listener-test")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public void test(String userId){
        userService.get(userId);
        log.info("userService get 함수 종료");
    }

}
