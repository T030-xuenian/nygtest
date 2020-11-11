package org.rising.test_customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/11 8:55
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consumer",method= RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://127.0.0.1:8193/system/getAllUser", String.class).getBody();
    }

}
