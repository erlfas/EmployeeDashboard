package no.fasmer.employeedashboard.vo;

import java.io.Serializable;

public class AreaOfExpertiseVO implements Serializable {

    public AreaOfExpertiseVO() {
    }

    public AreaOfExpertiseVO(String value) {
        this.value = value;
    }
    
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
