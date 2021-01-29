package hu.jnagy.registry.repository;


import hu.jnagy.registry.model.Gender;
import hu.jnagy.registry.service.IRegistry;
import hu.jnagy.registry.model.Person;

import java.time.LocalDate;

public class Populator {

    public static void populate(IRegistry registry) {

        Person p1 = new Person("Manager", "Brandon", "Ulrich", Gender.MALE, LocalDate.of(1975, 04, 29));
        Person p2 = new Person("Vice President", "Orsolya", "Bali", Gender.FEMALE, LocalDate.of(1989, 07, 12));
        Person p3 = new Person("Chief Technical Officer", "Balázs", "Bánfai", Gender.MALE, LocalDate.of(1971, 04, 03));
        Person p4 = new Person("Office Manager", "Ágnes", "Mezõ", Gender.FEMALE, LocalDate.of(1994, 05, 03));
        Person p5 = new Person("QA Analyst", "Zsófia", "Molnár", Gender.FEMALE, LocalDate.of(1995, 04, 18));
        Person p6 = new Person("Head of Product", "Márk", "Czotter", Gender.MALE, LocalDate.of(1991, 01, 23));
        Person p7 = new Person("Senior Developer", "András", "Péteri", Gender.MALE, LocalDate.of(1987, 12, 07));
        Person p8 = new Person("Senior Developer", "Gábor", "Nagy", Gender.MALE, LocalDate.of(1982, 10, 30));
        Person p9 = new Person("Senior Developer", "Endre", "Kovács", Gender.MALE, LocalDate.of(1985, 07, 30));
        Person p10 = new Person("Junior Developer", "Alina", "Al-Aswadi", Gender.FEMALE, LocalDate.of(1989, 10, 21));
        Person p11 = new Person("Junior Developer", "Norbert", "Orbán", Gender.MALE, LocalDate.of(1992, 10, 02));

        registry.addPerson(p1);
        registry.addPerson(p2);
        registry.addPerson(p3);
        registry.addPerson(p4);
        registry.addPerson(p5);
        registry.addPerson(p6);
        registry.addPerson(p7);
        registry.addPerson(p8);
        registry.addPerson(p9);
        registry.addPerson(p10);
        registry.addPerson(p11);

    }
}