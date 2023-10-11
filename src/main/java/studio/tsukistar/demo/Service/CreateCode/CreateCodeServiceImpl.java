package studio.tsukistar.demo.Service.CreateCode;

import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;

import studio.tsukistar.demo.Entity.ProjectInformationEntity;

@Service
public class CreateCodeServiceImpl implements CreateCodeService {
    @Override
    public String createCode(String name, String category) {
        /*if(category == "QT") {

        } else if(category == ""){

        } else {

        }*/
        return "PM000";
    }
        
    public ProjectInformationEntity storeProjectInformation(String name, String category) {
            ProjectInformationEntity entity = new ProjectInformationEntity();
            entity.setOperation("新增");
            entity.setCode("PM000");
            entity.setName(name);
            entity.setCategory(category);
            entity.setTime(getCurrentTime());
            return entity;
    }

    public Timestamp getCurrentTime() {
            Date currentDate = new Date();
            return new Timestamp(currentDate.getTime());
    }    
}