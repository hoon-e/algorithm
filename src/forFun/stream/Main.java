package forFun.stream;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative Approach
        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(person.getGender().equals(Gender.FEMALE))
                females.add(person);
        }

        // females.forEach(System.out::println);

        // Java streams
        
        // Filter
        List<Person> females2 = people.stream()
                // Takes predicate
                .filter(person ->
                    person.getGender().equals(Gender.FEMALE)
                )
                .collect(Collectors.toList());

        // Sort

        // people.forEach(System.out::println);

        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        // All match

        boolean isAll = people.stream()
                .allMatch(person -> person.getAge() > 5);

        // Any match

        boolean isAny = people.stream()
                .anyMatch(person -> person.getAge() > 5);

        // None match

        boolean none = people.stream()
                .noneMatch(person -> person.getName().equals("Sherlock"));

        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(
                (gender, people1) -> {
                    System.out.println(gender);
                    people1.forEach(System.out::println);
                }
        );
    }

    private static List<Person> getPeople(){
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Penny", 33, Gender.FEMALE),
                new Person("Marie", 47, Gender.FEMALE),
                new Person("Sherlock", 19, Gender.MALE),
                new Person("Harry", 18, Gender.MALE),
                new Person("Hermione", 50, Gender.FEMALE),
                new Person("John Snow", 20, Gender.MALE),
                new Person("Anna", 30, Gender.FEMALE)
        );
    }
}
