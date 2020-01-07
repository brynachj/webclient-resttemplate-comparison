package webclientresttemplatecomparison.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateGateway {

    private String teaServiceUrl = "http://localhost:8080/tea";
    private RestTemplate restTemplate = new RestTemplate();

    public String getMug() {
        return restTemplate.getForEntity(teaServiceUrl + "/mug", String.class).getBody();
    }

    public String getTeabag() {
        return restTemplate.getForEntity(teaServiceUrl + "/teabag", String.class).getBody();
    }

    public String getHotWater() {
        return restTemplate.getForEntity(teaServiceUrl + "/hot-water", String.class).getBody();
    }

    public String getMilk() {
        return restTemplate.getForEntity(teaServiceUrl + "/milk", String.class).getBody();
    }
}
