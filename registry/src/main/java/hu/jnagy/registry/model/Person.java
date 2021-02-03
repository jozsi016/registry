package hu.jnagy.registry.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(title, person.title) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && gender == person.gender && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, lastName, firstName, gender, dateOfBirth);
    }
}