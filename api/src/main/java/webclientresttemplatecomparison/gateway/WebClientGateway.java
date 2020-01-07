package webclientresttemplatecomparison.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientGateway {

    private String teaServiceUrl = "http://localhost:8080/tea";
    private WebClient webClient = WebClient.create(teaServiceUrl);

    public Mono<String> getMug() {
        return webClient.get().uri(teaServiceUrl + "/mug").retrieve().bodyToMono(String.class);
    }

    public Mono<String> getTeabag() {
        return webClient.get().uri(teaServiceUrl + "/teabag").retrieve().bodyToMono(String.class);
    }

    public Mono<String> getHotWater() {
        return webClient.get().uri(teaServiceUrl + "/hot-water").retrieve().bodyToMono(String.class);
    }

    public Mono<String> getMilk() {
        return webClient.get().uri(teaServiceUrl + "/milk").retrieve().bodyToMono(String.class);
    }
}
