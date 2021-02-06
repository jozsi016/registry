package hu.jnagy.registry.repository;

import hu.jnagy.registry.model.Gender;
import hu.jnagy.registry.model.Person;
import hu.jnagy.registry.service.Registry;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.time.LocalDate;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

public class PopulatorTest {

    @Test
    public void whenPopulateRegistryWillBeSetWithPerson() {
        //Given
        Person p1 = new Person("Manager", "Norbert", "Ulrich", Gender.MALE, LocalDate.of(1975, 04, 29));
        Registry registry = new Registry ();
        Registry spyRegistry = spy(registry);
        Populator systemUnderTest = new Populator();
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        //When
        systemUnderTest.populate(spyRegistry);
        //then
        Mockito.verify(spyRegistry, Mockito.times(11)).addPerson(captor.capture());
        assertThat(spyRegistry.getPersons().get(0), Is.is(p1));
    }

    @Test
    public void whenPopulateRegistryWillBeSetWithPersonSpy() {
        //Given
        Person p1 = new Person("Manager", "Norbert", "Ulrich", Gender.MALE, LocalDate.of(1975, 04, 29));
        Registry registry = new Registry();
        Registry spyRegistry = spy(registry);
        Populator systemUnderTest =  new Populator();
        //When
        systemUnderTest.populate(spyRegistry);
        //then
        Mockito.verify(spyRegistry, Mockito.times(11)).addPerson(Mockito.any());
        assertThat(registry.getPersons().get(0), Is.is(p1));
    }
}
