package webclientresttemplatecomparison.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webclientresttemplatecomparison.api.gateway.RestTemplateGateway;

@RestController()
@RequestMapping("/restTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateGateway restTemplateGateway;

    @GetMapping("/tea")
    public String getTea() {

        String mug = restTemplateGateway.getMug();
        String teabag = restTemplateGateway.getTeabag();
        String hotWater = restTemplateGateway.getHotWater();
        String milk = restTemplateGateway.getMilk();

        String[] responses = {mug, teabag, hotWater, milk, "tea has been made the restTemplate way"};
        return String.join("; ", responses);
    }

    @GetMapping("/tea/mug")
    public String getMug() {

        return restTemplateGateway.getMug();
    }

    @GetMapping("/tea/teabag")
    public String getTeabag() {

        return restTemplateGateway.getTeabag();
    }

    @GetMapping("/tea/hot-water")
    public String getHotWater() {

        return restTemplateGateway.getHotWater();
    }

    @GetMapping("/tea/milk")
    public String getMilk() {

        return restTemplateGateway.getMilk();
    }
}
