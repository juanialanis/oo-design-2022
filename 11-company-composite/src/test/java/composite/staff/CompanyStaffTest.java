package composite.staff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class CompanyStaffTest {

    CompanyStaff staff;

    DeveloperComponent allDevelopers;
    DeveloperComponent seniorOne;
    DeveloperComponent seniorTwo;
    DeveloperComponent seniorThree;

    DeveloperComponent managerOne;
    DeveloperComponent managerTwo;
    DeveloperComponent managerThree;

    public void init() {
         allDevelopers = new Developer("Jeff", "CEO");
         seniorOne = new Developer("Laura", "SENIOR MANAGER");
         seniorTwo = new Developer("Ravi", "SENIOR MANAGER");
         seniorThree = new Developer("Grant", "SENIOR MANAGER");

         managerOne = new Developer("Remy", "MANAGER");
         managerTwo = new Developer("Remy", "MANAGER");
         managerThree = new Developer("Remy", "MANAGER");
    }

    public void allDevelopers() {
        allDevelopers.add(seniorOne);
        allDevelopers.add(seniorTwo);
        allDevelopers.add(seniorThree);
    }

    public void seniors() {
        seniorOne.add(managerOne);
        seniorOne.add(managerTwo);
        seniorOne.add(managerThree);
    }

    public void managers() {
        managerOne.add(new DeveloperItem("Juan", "DEVELOPER"));
        managerOne.add(new DeveloperItem("Luca", "DEVELOPER"));
    }

    @BeforeEach
    public void setUp() {
        init();
        allDevelopers();
        seniors();
        managers();
        staff = new CompanyStaff(allDevelopers);
    }

    @Test
    public void printStaffTest() {
        staff.printStaff();
    }

    @ParameterizedTest
    @CsvSource({"Juan, true", "Remy, true", "Grant, true", "Bob, false"})
    public void existPersonTest(String person, boolean value) {
        assertEquals(staff.existPerson(person), value);
    }

    @ParameterizedTest
    @CsvSource({"Juan, Remy, true", "Juan, Laura, true", "Luca, Laura, true"})
    public void existDependencyTest(String personOne, String personTwo) {
        assertTrue(staff.existDependency(personOne, personTwo));
    }

    @Test
    public void printAllDevelopersTest() {
        staff.printAllDevelopers();
    }
}
