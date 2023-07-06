package com.example.commontest.eventlistener;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event-listener-test")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public void test(String userId){
        userService.get(userId);
    }

}
