package studio.tsukistar.demo.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import studio.tsukistar.demo.Entity.ProjectInformationEntity;

@Repository
public class ProjectInformationDao {
    private final JdbcTemplate jdbcTemplate;

    public ProjectInformationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addOperationInformation(ProjectInformationEntity proInfo) { //新增操作记录
        String sql = "insert into project_information (operation, code, name, category, operation_time) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, proInfo.getOperation(), proInfo.getCode(), proInfo.getName(), proInfo.getCategory(), proInfo.getTime());
    }

    public String selectLatestProjectCode(String category) {
        String code;
        String sql = "select code from project_information where operation = '新建编码' and category = ? order by id desc limit 1";
        code = jdbcTemplate.queryForObject(sql, new Object[]{category},String.class);
        return code;
    }
}