package org.example;

import org.apache.commons.lang3.StringUtils;

public class University {
    private String id, fullName, shortName;
    private int yearOfFoundation;

    private StudyProfile StudyProfile, mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile studyProfile, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.StudyProfile = studyProfile;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getStudyProfile() {
        return StudyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        StudyProfile = studyProfile;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", StudyProfile=" + StudyProfile.getProfileName() +
                ", mainProfile=" + mainProfile +
                '}';
    }

    // сортировка университетов по идентификатору
    public static class IdUniversityCompare implements UniversityInterface {
        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getId(), o2.getId());
        }
    }

    // сортировка университетов по полному наименованию
    public static class FullNameUniversityCompare implements UniversityInterface {
        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getFullName(), o2.getFullName());
        }
    }

    // сортировка университетов по короткому наименованию
    public static class ShortNameUniversityCompare implements UniversityInterface {
        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getShortName(), o2.getShortName());
        }
    }

    // сортировка университетов по году основания
    public static class YearOfFoundationUniversityCompare implements UniversityInterface {
        @Override
        public int compare(University o1, University o2) {
            return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
        }
    }

    // сортировка университетов по профилю студентов
    public static class StudentProfileCompare implements UniversityInterface {
        @Override
        public int compare(University o1, University o2) {
            return StringUtils.compare(o1.getStudyProfile().getProfileName(), o2.getStudyProfile().getProfileName());
        }
    }
}
