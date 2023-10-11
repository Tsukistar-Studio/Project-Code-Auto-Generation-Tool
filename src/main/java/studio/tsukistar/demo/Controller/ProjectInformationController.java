package studio.tsukistar.demo.Controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.*;

import studio.tsukistar.demo.Service.CreateResponse.CreateResponseService;

@RestController
@RequestMapping("/project")
public class ProjectInformationController {
    private final CreateResponseService responseService;

    public ProjectInformationController(CreateResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/code/create")
    public JSONObject createProjectCode(@RequestBody JSONObject jsonData) {
        return responseService.createJsonResponse("新建编码", jsonData);
    }
    
    @PostMapping("/name/update")
    public JSONObject updateProjectName(@RequestBody JSONObject jsonData) {
        return responseService.createJsonResponse("更新名称", jsonData);
    }
}