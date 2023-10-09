package studio.tsukistar.demo.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import studio.tsukistar.demo.Entity.ProjectInformationEntity;

@Repository
public class ProjectInformationDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void addProjectCode(ProjectInformationEntity proInfo) { //新增项目编码
        jdbcTemplate.update("insert into project_information values (?,?,?,?,?)",
                            proInfo.getOperation(),
                            proInfo.getCode(),
                            proInfo.getName(),
                            proInfo.getCategory(),
                            proInfo.getTime());
    }
    public void updateProjectInformation(ProjectInformationEntity proInfo) { //更新项目名称
        jdbcTemplate.update("update project_information set name = ? where code = ?",
                            proInfo.getName(),
                            proInfo.getCode());
    }
}