package studio.tsukistar.demo.Service.StoreProjectInformation;

import org.springframework.stereotype.Service;
import studio.tsukistar.demo.Entity.ProjectInformationEntity;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class StoreProjectInformationServiceImpl implements StoreProjectInformationService{
    @Override
    public ProjectInformationEntity storeProjectInformation(String operation, String code, String name, String category) {
        ProjectInformationEntity entity = new ProjectInformationEntity();
        entity.setOperation(operation);
        entity.setCode(code);
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