package org.rising.test_customer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rising.test_customer.bean.User;
import org.rising.test_customer.service.UserFeignClient;
import org.rising.web.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/11 8:55
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private UserFeignClient feignClient;

    @RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
    public WebResult helloConsumer() {
        WebResult allUser = feignClient.findAllUser();

        return allUser;
    }
}
