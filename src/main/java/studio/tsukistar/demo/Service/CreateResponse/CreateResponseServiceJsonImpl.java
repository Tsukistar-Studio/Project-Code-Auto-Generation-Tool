package studio.tsukistar.demo.Service.CreateResponse;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

import studio.tsukistar.demo.Service.CreateCode.CreateCodeService;
import studio.tsukistar.demo.Service.UpdateName.UpdateNameService;

@Service
public class CreateResponseServiceJsonImpl implements CreateResponseService{

    private final CreateCodeService createCodeService;
    private final UpdateNameService updateNameService;

    public CreateResponseServiceJsonImpl(CreateCodeService createCodeService, UpdateNameService updateNameService) {
        this.createCodeService = createCodeService;
        this.updateNameService = updateNameService;
    }
    @Override
    public JSONObject createJsonResponse(String operation,JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String category = jsonObject.getString("category");
        String code;

        if(operation.equals("新建编码")) {
            code = createCodeService.createCode(name, category);
        } else {
            code = jsonObject.getString("code");
            updateNameService.updateName(code, name, category);
        }
        
        JSONObject responseJsonObject = new JSONObject();
        responseJsonObject.put("code",code);
        responseJsonObject.put("name",name);
        responseJsonObject.put("category",category);
        return responseJsonObject;
    }
}