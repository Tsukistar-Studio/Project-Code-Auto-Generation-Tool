package studio.tsukistar.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CreateNumberController {
    @PostMapping("/number")
    public String myEndpoint(@RequestParam String param1, @RequestParam int param2) {
        // 处理POST请求的代码
        return "success";
    }
}