package studio.tsukistar.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/hello")
    public String hello() {
        String hellotext;
        hellotext = Integer.toString(100, 34);
        return hellotext;
    }
}