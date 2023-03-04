package org.example;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

//@XmlRootElement(name = "statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @SerializedName("Профиль обучения")
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @SerializedName("Средний балл")
    @XmlElement(name = "avgScore")
    private BigDecimal avgExamScore;
    @SerializedName("Количество студентов по профилю")
    @XmlTransient
    private int studentCountByProfile;
    @SerializedName("Количество университетов по профилю")
    @XmlTransient
    private int universityCountByProfile;
    @SerializedName("Название университетов")
    @XmlTransient
    private List<String> universityName;

    public Statistics() {
    }

    public Statistics(StudyProfile studyProfile, BigDecimal avgExamScore, int studentCountByProfile, int universityCountByProfile, List<String> universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentCountByProfile = studentCountByProfile;
        this.universityCountByProfile = universityCountByProfile;
        this.universityName = universityName;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public BigDecimal getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(BigDecimal avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentCountByProfile() {
        return studentCountByProfile;
    }

    public void setStudentCountByProfile(int studentCountByProfile) {
        this.studentCountByProfile = studentCountByProfile;
    }

    public int getUniversityCountByProfile() {
        return universityCountByProfile;
    }

    public void setUniversityCountByProfile(int universityCountByProfile) {
        this.universityCountByProfile = universityCountByProfile;
    }

    public List<String> getUniversityName() {
        return universityName;
    }

    public void setUniversityName(List<String> universityName) {
        this.universityName = universityName;
    }
}
