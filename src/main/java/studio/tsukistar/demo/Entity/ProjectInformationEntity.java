package studio.tsukistar.demo.Entity;

import java.sql.Timestamp;

public class ProjectInformationEntity {
    private String operation;
    private String code;
    private String name;
    private String category;
    private Timestamp operation_time;
    
    //get方法
    public String getOperation() {
        return operation;
    }
    public String getCode() {
        return this.code;
    }
    public String getName() {
        return this.name;
    }
    public String getCategory() {
        return this.category;
    }
    public Timestamp getTime() {
        return operation_time;
    }

    //set方法
    public void setOperation(String system_operation) {
        this.operation = system_operation;
    }

    public void setCode(String projectCode) {
        this.code = projectCode;
    }
    public void setName(String projectName) {
        this.name = projectName;
    }
    public void setCategory(String projectCategory) {
        this.category = projectCategory;
    }
    public void setTime(Timestamp operationTime) {
        this.operation_time = operationTime;
    }
}