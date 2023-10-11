package studio.tsukistar.demo.Service.UpdateName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;

import studio.tsukistar.demo.Entity.ProjectInformationEntity;
import studio.tsukistar.demo.Dao.ProjectInformationDao;

@Service
public class UpdateNameServiceImpl implements UpdateNameService {
    private final ProjectInformationDao projectInformationDao;

    public UpdateNameServiceImpl(ProjectInformationDao projectInformationDao) {
        this.projectInformationDao = projectInformationDao;
    }

    @Override
    public void updateName(String code, String name, String category) {
        ProjectInformationEntity projectInformation = storeProjectInformation(code, name, category);
        projectInformationDao.addOperationInformation(projectInformation);
    }
    
    public ProjectInformationEntity storeProjectInformation(String code, String name, String category) {
        ProjectInformationEntity entity = new ProjectInformationEntity();
        entity.setOperation("更新名称");
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