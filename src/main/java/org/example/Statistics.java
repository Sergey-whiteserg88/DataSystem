package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalDouble;

public class Statistics {
    private String studyProfile;
    private BigDecimal avgExamScore;
    private int studentCountByProfile;
    private int universityCountByProfile;
    private List<String> universityName;

    public Statistics(String studyProfile, BigDecimal avgExamScore, int studentCountByProfile, int universityCountByProfile, List<String> universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentCountByProfile = studentCountByProfile;
        this.universityCountByProfile = universityCountByProfile;
        this.universityName = universityName;
    }

    public String getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(String studyProfile) {
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
