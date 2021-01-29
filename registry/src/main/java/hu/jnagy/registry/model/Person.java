package hu.jnagy.registry.model;

import java.time.LocalDate;
import java.time.Period;

public class Person implements Comparable<Person> {
    String title;
    String lastName;
    String firstName;
    Gender gender;
    LocalDate dateOfBirth;

    public Person(String title, String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;

    }

    public String getTitle() {
        return title;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person [" + " title: " + title + ", firstName: " + firstName + ", lastName: " + lastName + ", gender: "
                + gender + ", dateOfBirth: " + dateOfBirth + "]" + "\n";
    }

    @Override
    public int compareTo(Person p2) {
        return lastName.compareTo(p2.lastName);
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int year = Period.between(dateOfBirth, today).getYears();
        return year;
    }

}