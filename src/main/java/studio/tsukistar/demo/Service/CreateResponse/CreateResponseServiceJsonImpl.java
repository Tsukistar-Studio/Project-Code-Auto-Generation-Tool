package studio.tsukistar.demo.Service.CreateResponse;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

import studio.tsukistar.demo.Entity.ProjectInformationEntity;
import studio.tsukistar.demo.Dao.ProjectInformationDao;

@Service
public class CreateResponseServiceJsonImpl implements CreateResponseService{
    public JSONObject createJsonResponse(JSONObject jsonObject) {
        String code = "";
        String name = jsonObject.getString("name");
        String category = jsonObject.getString("category");
        if(category == "QT") {
            
        } else if(category == ""){
            
        } else {
            
        }
        
        ProjectInformationEntity projectInformation = new ProjectInformationEntity();
        projectInformation.setOperation("新增");
        
        JSONObject responseJsonObject = new JSONObject();
        responseJsonObject.put("code",code);
        responseJsonObject.put("name",name);
        responseJsonObject.put("category",category);
        
        return responseJsonObject;
    }
}