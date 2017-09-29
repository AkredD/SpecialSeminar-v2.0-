package employees;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by user on 29.09.2017.
 */


public class Parser {
    private static List <Employee> people;
    public Parser(List <Employee> people){
        this.people = people;
    }

    public static int maxSalary(){
        //return people.stream().reduce((a, b) -> new Employee(null, null, Math.max(a.salary, b.salary))).get().salary;
        //return people.stream().mapToInt((e) -> e.salary).max().getAsInt();
        return people.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary - o2.salary;
            }
        }).get().salary;
    }
    public static int minSalary() {
        //return people.stream().reduce((a, b) -> new Employee(null, null, Math.min(a.salary, b.salary))).get().salary;
        //return people.stream().mapToInt((e) -> e.salary).min().getAsInt();
        return people.stream().min(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary - o2.salary;
            }
        }).get().salary;
    }
    public static double averageSalary(){
        return people.stream().mapToInt((e) -> e.salary).average().getAsDouble();
    }

    public static Map<String, Integer> jobCount(){
        return people.stream().collect(Collectors.toMap((e) -> e.position, (e) -> 1, (a,b) -> a + b));
    }

    public static Map<Character, Integer> abc(){
        return people.stream().collect(Collectors.toMap((e) -> e.surname.charAt(0), (e) -> 1, (a,b) -> a + b));
    }
}
