package interfaces;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Create a class called CompanyEmployee that implements both
//   the Company and Employee interfaces
// Implement the necessary methods
// Give the class a two-arg constructor that takes first and last name
// Implement the getName method so that the test below passes


// Records
// GA in java 16
// immutable data holders
// autoGenerate equal and hashCode methods
// have getters of the form first(), last() etc..
// use primary constructor before class body

//public record CompanyEmployeeRecord(String first, String last) implements Company, Employee {
//    public String getName() {
//        return Employee.super.getName() + " works for " + Company.super.getName();
//    }
//
//    public void doWork() {
//
//    }
//}

class CompanyEmployee implements Company, Employee {

    private final String firstName;
    private final String lastName;
    public CompanyEmployee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String getFirst() {
        return this.firstName;
    }

    public String getName() {
        return Employee.super.getName() + " works for " + Company.super.getName();
    }

    @Override
    public String getLast() {
        return this.lastName;
    }

    @Override
    public void doWork() {

    }
}
public class CompanyEmployeeTest {

    @Test
    public void getName() {
        CompanyEmployee emp = new CompanyEmployee("Peter", "Gibbons");
        assertEquals("Peter Gibbons works for Initech", emp.getName());
    }
}