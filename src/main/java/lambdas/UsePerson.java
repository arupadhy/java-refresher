package lambdas;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {
    @SuppressWarnings({"UnusedAssignment", "Convert2MethodRef"})
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Paul", "George", "Ringo");
//
//        List<Person> people = names.stream()    // Stream<String>
//                .map(name -> new Person(name))  // Stream<Person>
//                .collect(Collectors.toList());  // Converts Stream<Person> to List<Person>
//
//        people.forEach(System.out::println);
//
//        people = names.stream()
//                .map(Person::new)
//                .collect(Collectors.toList());
//
//        System.out.println(people);
//
//        Person[] peopleArray = names.stream()
//                .map(Person::new)
//                .toArray(Person[]::new); // creates an array of persons
//        //      .toArray(value -> new Person[value]);
//
//        System.out.println(Arrays.toString(peopleArray));

        List<String> fullNames = List.of("Arvind Upadhyay", "John Wickr", "Donald Junior", "Paul Paula");
        Person[] persons = fullNames.stream()
                .map(Person::new)
                .toArray(Person[]::new);

        System.out.println(Arrays.deepToString(persons));

        // collect version with multiple args
        LinkedList<Person> linkedListPersons = names.stream()
                .map(Person::new)
                .collect(
                        () -> new LinkedList<Person>(), // Supplier<LinkedList>
                        (list, person) -> list.add(person), // BiConsumer<LinkedList,Person>
                        (list1, list2) -> list1.addAll(list2) // BiConsumer<LinkedList, LinkedList>
                );

        // older verison updated using method references
        LinkedList<Person> secondVersion = names.stream()
                .map(Person::new)
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        // older version updated using toCollection
        LinkedList<Person> thirdVersion = names.stream()
                .map(Person::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
