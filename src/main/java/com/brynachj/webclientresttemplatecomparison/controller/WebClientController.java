package com.brynachj.webclientresttemplatecomparison.controller;

import com.brynachj.webclientresttemplatecomparison.gateway.WebClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/webClient")
public class WebClientController {

    @Autowired
    private WebClientGateway webClientGateway;

    @GetMapping("/tea")
    public Mono<String> getTea() {

        Mono<String> mugResponse = webClientGateway.getMug();
        Mono<String> teabagResponse = webClientGateway.getTeabag();
        Mono<String> hotWaterResponse = webClientGateway.getHotWater();
        Mono<String> milkResponse = webClientGateway.getMilk();

        Flux<String> stringFlux = mugResponse.concatWith(teabagResponse).concatWith(hotWaterResponse).concatWith(milkResponse).concatWith(Mono.just("tea has been made the webClient way"));
        return stringFlux.reduce((a, b) -> a + "; " + b);

    }

    @GetMapping("/tea/mug")
    public Mono<String> getMug() {

        return webClientGateway.getMug();
    }

    @GetMapping("/tea/teabag")
    public Mono<String> getTeabag() {

        return webClientGateway.getTeabag();
    }

    @GetMapping("/tea/hot-water")
    public Mono<String> getHotWater() {

        return webClientGateway.getHotWater();
    }

    @GetMapping("/tea/milk")
    public Mono<String> getMilk() {

        return webClientGateway.getMilk();
    }

}
