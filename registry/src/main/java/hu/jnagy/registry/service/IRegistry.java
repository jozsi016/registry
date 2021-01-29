package hu.jnagy.registry.service;

import hu.jnagy.registry.model.Person;
import hu.jnagy.registry.model.Gender;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IRegistry {

    Set<Person> filterByGender(Gender gender);

    List<Person> sortByLastName();

    List<Person> sortByGender();

    List<Person> sortByBirthday();

    int getCalcSumAgeMale();

    double getCalcAvgAgeMale();

    void addPerson(Person p1);

    boolean removePerson(Person p1);

    void clear();

    boolean isEmpty();

    Map<Integer, Person> getPersons();

    void toJason();
}
