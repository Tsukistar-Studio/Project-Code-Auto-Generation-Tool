package studio.tsukistar.demo.Entity;

public class ProjectInformationEntity {
    private String name;
    private String operate;
    private String source;
    private String status;
    
    //get方法
    public String getName() {
        return this.name;
    }
    public String getOperate() {
        return this.operate;
    }
    public String getSource() {
        return this.source;
    }
    public String getStatus() {
        return this.status;
    }
    
    //set方法
    public void setName(String projectName) {
        this.name = projectName;
    }
    public void setOperate(String projectOperate) {
        this.operate = projectOperate;
    }
    public void setSource(String projectSource) {
        this.source = projectSource;
    }
    public void setStatus(String projectStatus) {
        this.status = projectStatus;
    }
}