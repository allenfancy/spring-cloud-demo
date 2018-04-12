package org.spring.cloud.service.user.controller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/zipkin")
public class ZipkinDemoController {

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/demo1")
    public String start() throws InterruptedException, IOException {
        long sleep = ThreadLocalRandom.current().nextLong();
        Request request = new Request.Builder().url("http://baidu.com").get().build();
        Response response = okHttpClient.newCall(request).execute();
        return " [service1 sleep " + sleep+" ms]" + response.body().toString();
    }

    @RequestMapping("/demo2")
    public String restTemplate() throws InterruptedException {
        long sleep = ThreadLocalRandom.current().nextLong();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://baidu.com", String.class);
        return " [service1 sleep " + sleep+" ms]" + forEntity.toString();
    }

}
