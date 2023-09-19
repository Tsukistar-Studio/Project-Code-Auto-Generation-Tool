package studio.tsukistar.demo.Controller;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "response")
public class ProjectNumberResponse {
    private String number;
    private String status;

    //get方法
    public String getNumber() {
        return this.number;
    }
    public String getStatus() {
        return this.status;
    }

    //set方法
    public void setNumber(String number) {
        this.number = number;
    }
    public void setStatus(String projectStatus) {
        this.status = projectStatus;
    }
}