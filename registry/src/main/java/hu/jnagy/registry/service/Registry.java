package hu.jnagy.registry.service;

import hu.jnagy.registry.model.Gender;
import hu.jnagy.registry.model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Registry implements IRegistry{
    List<Person> personList = new ArrayList<>();

    public void addPerson(Person p1) {
        personList.add(p1);
    }

    public Map<Integer, Person> getPersons() {
        Map<Integer, Person> map = new HashMap<>();
        int i = 0;
        for(Person p: personList) {
            map.put(i,p);
            i++;
        }
        return map;
    }

    public List<Person> sortByLastName() {
        Collections.sort(personList);
        return personList;
    }

    public List<Person> sortByGender() {
        Collections.sort(personList, Comparator.comparing(Person::getGender));
        return personList;
    }

    public boolean removePerson(Person p1) {
        return personList.remove(p1);
    }

    public void clear() {
        personList.removeAll(personList);
    }


    @Override
    public Set<Person> filterByGender(Gender gender) {
        return personList.stream().filter(person -> person.getGender().equals(gender)).collect(Collectors.toSet());
    }

    @Override
    public boolean isEmpty() {
        return personList.isEmpty();
    }

    @Override
    public List<Person> sortByBirthday() {
        personList.sort(Comparator.comparing(Person::getDateOfBirth));
        return personList;
    }

    @Override
    public int getCalcSumAgeMale() {
        return personList.stream().filter(person -> person.getGender().equals(Gender.MALE)).mapToInt(p->p.getAge()).sum();
    }

    @Override
    public double getCalcAvgAgeMale() {
       return personList.stream().
               filter(person -> person.getGender().equals(Gender.MALE)).
               mapToInt(p->p.getAge()).
               average().getAsDouble();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : personList) {
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }
}