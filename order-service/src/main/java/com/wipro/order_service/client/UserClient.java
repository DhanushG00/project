package com.wipro.order_service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wipro.order_service.io.UserResponse;

@Component
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8081/users";

    public UserResponse getUserById(Long userId) {
        return restTemplate.getForObject(BASE_URL + "/" + userId, UserResponse.class);
    }
}