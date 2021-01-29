package hu.jnagy.registry.service;

import hu.jnagy.registry.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Registry {
    List<Person> personList = new ArrayList<>();

    public void addPerson(Person p1) {
        personList.add(p1);
    }

    public List<Person> getPersons() {
        return personList;
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

    public List<Person> sortByLastName() {
        Collections.sort(personList);
        return personList;
    }

    public List<Person> sortByGender() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getGender().compareTo(o2.getGender());
            }
        });
        return personList;
    }

    public void removePerson(Person p1) {
        personList.remove(p1);
    }

    public void clear() {
        personList.removeAll(personList);
    }
}