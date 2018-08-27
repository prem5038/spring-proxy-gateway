package com.prem.proxy.springproxygateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    Logger logger = LoggerFactory.getLogger(ProxyController.class);

    @Value("${remote.server.name}")
    String remoteServerName;

    @Value("${remote.server.port}")
    int remoteServerPort;

    @GetMapping("/proxy/**")
    public ResponseEntity<String> proxyGet(ProxyExchange<String> proxy) throws Exception {
        String path = proxy.path("/proxy");
        String requestURL = "http://"+remoteServerName+":"+remoteServerPort+path;
        logger.debug("Serving from request URL: "+requestURL);
        return proxy.uri(requestURL).get();
    }

    @PostMapping("/proxy/**")
    public ResponseEntity<String> proxyPost(ProxyExchange<String> proxy) throws Exception {
        String path = proxy.path("/proxy");
        String requestURL = "http://"+remoteServerName+":"+remoteServerPort+"/"+path;
        logger.debug("Serving from request URL: "+requestURL);
        return proxy.uri(requestURL).post();
    }
}
