package hu.jnagy.registry.service;

import hu.jnagy.registry.model.Gender;
import hu.jnagy.registry.model.Person;
import hu.jnagy.registry.repository.Populator;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistryTest {
    Registry systemUnderTest;

    @Before
    public void setUp() {
        systemUnderTest = new Registry();
        Populator.populate(systemUnderTest);
    }

    @Test
    public void shouldGiveBackEveryPerson() {
        //Given
        Map<Integer, Person> systemUnderTest = this.systemUnderTest.getPersons();
        Person expected = new Person("Developer", "Brandon", "Orbán", Gender.MALE, LocalDate.of(1992, 10, 02));
        //When
        Person actual = systemUnderTest.get(10);
        int numberOfPerson = systemUnderTest.size();
        //Then
        assertThat(actual, is(expected));
        assertThat(numberOfPerson, is(11));
    }

    @Test
    public void shouldSortedByBirthday() {
        //Given
        Person expected = new Person("QA", "Zsófia", "Kovacs", Gender.FEMALE, LocalDate.of(1999, 04, 18));
        List<Person> systemUnderTest = this.systemUnderTest.sortByBirthday();
        //When
        Person actual = systemUnderTest.get(10);
        //Then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnTheSumOfTheMaleAge() {
        //Given
        int expected = 264;
        //When
        int actual = systemUnderTest.getCalcSumAgeMale();
        //Then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnTheAverageAgeMales() {
        //Given
        DecimalFormat df = new DecimalFormat("#.##");
        double expected = 37.71;
        //When
        double actual = Double.valueOf(df.format(systemUnderTest.getCalcAvgAgeMale()));
        //Then
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldBeEmptyWhenClearCalledOnRegistry(){
        //Given
        boolean empty =  true;
        //When
        systemUnderTest.clear();
        boolean actual = systemUnderTest.isEmpty();
        //Then
        assertThat(actual, is(empty));
    }
}
