package studio.tsukistar.demo.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import studio.tsukistar.demo.Controller.ProjectNumberRequest;
import studio.tsukistar.demo.Controller.ProjectNumberResponse;

import java.util.Objects;
@Service
public class CreateNumberService {
    private static final String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    
    public String createService(ProjectNumberRequest request) {
        ProjectNumberResponse response = new ProjectNumberResponse();
        response.setNumber( "AB000" );
        response.setStatus(request.getStatus());
        return javaBeanToXml (response);
    }
    
    public static String javaBeanToXml(Object obj) {
        String xml= "";
        if (Objects.isNull(obj)) {
            return xml;
        }
        
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xml = xmlMapper.writeValueAsString(obj);
        } catch (Exception e) {
            return "";
        }
        
        return XML_HEAD + xml;
    }
}
