package studio.tsukistar.demo.Entity;

public class ProjectNumberEntity {
    private String number;
    private String status;

    //get方法
    public String getProjectNumber() {
        return this.number;
    }
    public String getProjectStatus() {
        return this.status;
    }

    //set方法
    public void setProjectNumber(String projectNumber) {
        this.number = projectNumber;
    }
    public void setProjectStatus(String projectStatus) {
        this.status = projectStatus;
    }
}