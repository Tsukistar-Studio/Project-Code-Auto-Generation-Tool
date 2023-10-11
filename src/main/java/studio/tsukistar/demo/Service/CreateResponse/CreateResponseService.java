package studio.tsukistar.demo.Service.CreateResponse;

import com.alibaba.fastjson2.JSONObject;

public interface CreateResponseService {
    JSONObject createJsonResponse(String operation,JSONObject jsonObject);
}
