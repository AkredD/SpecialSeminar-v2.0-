package employees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Created by user on 29.09.2017.
 */


public class Employee {
    public String surname;
    public String position;
    public Integer salary;

    public Employee(String line){
        try {
            String[] local = line.split(", ");
            surname = local[0];
            position = local[1];
            salary = Integer.parseInt(local[2]);
        }catch (Exception e){
            System.out.print("wrong type");
            e.printStackTrace();
        }
    }

    public Employee(String surname, String position, Integer salary){
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }
}
