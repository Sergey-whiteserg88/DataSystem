package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
//    HISTORY("История"),
//    SOCIOLOGY("Социология"),
//    AVIATION("Авиация"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
