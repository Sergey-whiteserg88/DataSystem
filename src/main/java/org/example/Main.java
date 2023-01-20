package org.example;

public class Main {
    public static void main(String[] args) {
        University university = new University("1", "Московский государственный университет", "МГУ",
                1755, 50, 10);
        Student student = new Student("Иванов Иван Иванович", "1", 2, 4.8f);
        System.out.println(university);
        System.out.println(student);
    }
}