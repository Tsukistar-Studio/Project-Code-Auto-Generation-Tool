package studio.tsukistar.demo.Controller;

import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studio.tsukistar.demo.Service.CreateNumberService;

@RestController
@RequestMapping("/api")
public class CreateNumberController {
    @Resource
    private CreateNumberService numberService;

    @PostMapping(value="/number", produces = MediaType.APPLICATION_XML_VALUE)
    public String createNumber(@RequestBody ProjectNumberRequest request) { // 处理POST请求的代码
        return numberService.createService(request);
    }
}