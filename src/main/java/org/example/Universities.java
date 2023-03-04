package org.example;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "universitiesInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Universities {
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    public Universities(){}
    public Universities(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }
}
