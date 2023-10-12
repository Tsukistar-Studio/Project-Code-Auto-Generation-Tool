package studio.tsukistar.demo.Service.UpdateName;

import org.springframework.stereotype.Service;

import studio.tsukistar.demo.Service.StoreProjectInformation.StoreProjectInformationService;
import studio.tsukistar.demo.Entity.ProjectInformationEntity;
import studio.tsukistar.demo.Dao.ProjectInformationDao;

@Service
public class UpdateNameServiceImpl implements UpdateNameService {
    private final ProjectInformationDao projectInformationDao;
    private final StoreProjectInformationService storeProjectInformationService;

    public UpdateNameServiceImpl(ProjectInformationDao projectInformationDao, StoreProjectInformationService storeProjectInformationService) {
        this.projectInformationDao = projectInformationDao;
        this.storeProjectInformationService = storeProjectInformationService;
    }

    @Override
    public void updateName(String code, String name, String category) {
        String operation = "更新名称";
        ProjectInformationEntity projectInformation = storeProjectInformationService.storeProjectInformation(operation, code, name, category);
        projectInformationDao.addOperationInformation(projectInformation);
    }
}