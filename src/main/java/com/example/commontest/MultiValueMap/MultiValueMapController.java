package com.example.commontest.MultiValueMap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MultiValueMapController {

    @GetMapping("/mvm")
    public String get (Request request) {
        log.info("request body= {}", request.toString());
        return request.toString();
    }

    @GetMapping("/get2")
    public String get2 (MultiValueMapTestDto1 request) {
        log.info("request body= {}", request.toString());
        return request.toString();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Request {
        private List<String> name;

        @Override
        public String toString() {
            return String.join(", ", name);
        }
    }

}
