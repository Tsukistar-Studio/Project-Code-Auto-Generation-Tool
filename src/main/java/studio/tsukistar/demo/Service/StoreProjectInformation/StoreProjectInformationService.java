package studio.tsukistar.demo.Service.StoreProjectInformation;

import studio.tsukistar.demo.Entity.ProjectInformationEntity;

public interface StoreProjectInformationService {
    ProjectInformationEntity storeProjectInformation(String operation, String code, String name, String category);
}