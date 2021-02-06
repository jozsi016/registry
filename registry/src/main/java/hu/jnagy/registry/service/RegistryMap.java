package hu.jnagy.registry.service;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.jnagy.registry.model.Gender;
import hu.jnagy.registry.model.Person;

import java.beans.XMLEncoder;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistryMap extends HashMap<Integer, Person> implements IRegistry {

    @Override
    public Set<Person> filterByGender(Gender gender) {
        Set<Person> person = new HashSet<Person>(this.values());
        Stream<Person> result = person.stream();
        return result.filter(r -> r.getGender() == gender)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Person> sortByLastName() {
        List<Person> result = new ArrayList<Person>(this.values());
        Collections.sort(result);
        return result;
    }

    @Override
    public List<Person> sortByGender() {
        List<Person> result = new ArrayList<Person>(this.values());
        Collections.sort(result, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getGender().compareTo(o2.getGender());
            }
        });
        return result;
    }

    @Override
    public List<Person> sortByBirthday() {
        List<Person> result = new ArrayList<Person>(this.values());
        Collections.sort(result, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return MonthAndDay(o1.getDateOfBirth()).compareTo(MonthAndDay(o2.getDateOfBirth()));
            }

            public String MonthAndDay(LocalDate date) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM,dd");
                String formattedDate = date.format(formatter);
                return formattedDate;
            }
        });
        return result;
    }

    @Override
    public int getCalcSumAgeMale() {
        Stream<Person> result = this.values().stream();
        return result.filter(e -> e.getGender() == Gender.MALE)
                .mapToInt(e -> e.getAge()).sum();
    }

    @Override
    public double getCalcAvgAgeMale() {
        Stream<Person> result = this.values().stream();
        return result.filter(e -> e.getGender() == Gender.MALE)
                .mapToDouble(e -> e.getAge()).average().getAsDouble();
    }

    @Override
    public void addPerson(Person p1) {
        int key = 0;
        if (!(this.isEmpty())) {
            Set<Integer> keySets = this.keySet();
            key = Collections.max(keySets);
            key++;
        }
        this.put(key, p1);
    }

    @Override
    public boolean removePerson(Person p1) {
        return this.values().remove(p1);
    }

    @Override
    public Map<Integer, Person> getPersons() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person pers : this.values()) {
            sb.append(pers);
            sb.append("\n");
        }
        return sb.toString();
    }


    public void toXML() {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Person.xml")));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        }
        encoder.writeObject(this);
        encoder.close();
    }

    public void toJason() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("c:\\Users\\Jozsi\\Repos\\registry\\file.json"), this.values());
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
