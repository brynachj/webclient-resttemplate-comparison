package webclientresttemplatecomparison.teaService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tea")
public class TeaController {

    public static final Logger logger = LoggerFactory.getLogger(TeaController.class);

    @GetMapping("/mug")
    public String getMug() throws InterruptedException {
        logger.info("fetching a mug");
        Thread.sleep(250);
        return "got a mug";
    }

    @GetMapping("/teabag")
    public String getTeabag() throws InterruptedException {
        logger.info("fetching a teabag");
        Thread.sleep(250);
        return "got a teabag";
    }

    @GetMapping("/milk")
    public String getMilk() throws InterruptedException {
        logger.info("fetching milk");
        Thread.sleep(250);
        return "got milk";
    }

    @GetMapping("/hot-water")
    public String getHotWater() throws InterruptedException {
        logger.info("fetching hot-water");
        Thread.sleep(250);
        return "got hot water";
    }
}
