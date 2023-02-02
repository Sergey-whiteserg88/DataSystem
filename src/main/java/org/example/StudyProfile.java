package org.example;

public enum StudyProfile {
    MEDICINE("��������"),
    HISTORY("�������"),
    SOCIOLOGY("����������"),
    AVIATION("�������"),
    PHYSICS("������"),
    LINGUISTICS("�����������"),
    MATHEMATICS("����������");

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
