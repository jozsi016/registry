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

public class PopulatorTest {

    @Test
    public void whenPopulateRegistryWillBeSetWithPerson() {
        //Given
        Person p1 = new Person("Manager", "Brandon", "Ulrich", Gender.MALE, LocalDate.of(1975, 04, 29));
        Registry registry = Mockito.mock(Registry.class);
        Populator systemUnderTest = new Populator();
        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);
        //When
        systemUnderTest.populate(registry);
        //then
        Mockito.verify(registry, Mockito.times(11)).addPerson(captor.capture());
        assertThat(registry.getPersons().get(0), Is.is(p1));
    }

    @Test
    public void whenPopulateRegistryWillBeSetWithPersonSpy() {
        //Given
        Person p1 = new Person("Manager", "Brandon", "Ulrich", Gender.MALE, LocalDate.of(1975, 04, 29));
        Registry registry = new Registry();
        Registry registrySpy = Mockito.spy(registry);
        Populator systemUnderTest =  new Populator();
        //When
        systemUnderTest.populate(registrySpy);
        //then
        Mockito.verify(registrySpy, Mockito.times(11)).addPerson(Mockito.any());
        assertThat(registry.getPersons().get(0), Is.is(p1));
    }
}
