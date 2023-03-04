package org.example;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataForXmlJsonFile {
    @XmlElement(name = "studentsInfo")
    private Students students;
    @XmlElement(name = "universitiesInfo")
    private Universities universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statistics;

    @XmlElement(name = "processedAt")
    private String localDateTime;

    public DataForXmlJsonFile() {
    }

    public DataForXmlJsonFile(Students students, Universities universities, List<Statistics> statistics, String localDateTime) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
        this.localDateTime = localDateTime;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Universities getUniversitets() {
        return universities;
    }

    public void setUniversitets(Universities universities) {
        this.universities = universities;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }
}
