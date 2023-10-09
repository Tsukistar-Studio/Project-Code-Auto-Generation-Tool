package studio.tsukistar.demo.Controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.*;

import studio.tsukistar.demo.Service.CreateResponse.CreateResponseService;

@RestController
@RequestMapping("/project")
public class CodeInformationController {
    private final CreateResponseService responseService;
    public CodeInformationController(CreateResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/code/create")
    public JSONObject createProjectCode(@RequestBody JSONObject jsonData) {
        return responseService.createJsonResponse(jsonData);
    }
    
    @PostMapping("/name/update")
    public JSONObject updateProjectName(@RequestBody JSONObject jsonData) {
        // 处理接收到的 JSON 数据
        return responseService.createJsonResponse(jsonData);
    }
}