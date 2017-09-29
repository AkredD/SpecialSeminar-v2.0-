package employees;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


/**
 * Created by user on 29.09.2017.
 */


public class mainParseTest {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new File("logs.txt"));
        List<Employee> people = new ArrayList<>();
        try {
            File file = new File("input.txt");
            people = Files.readAllLines(file.toPath()).stream().map(Employee::new).collect(Collectors.toList());

        }catch (IOException e){
            System.out.print("wrong file");
        }


        Parser doIt = new Parser(people);
        out.println("maxSalary");
        out.println(doIt.maxSalary());
        out.println("minSalary");
        out.println(doIt.minSalary());
        out.println("avarageSalary");
        out.println(doIt.averageSalary());
        out.println("jobCount");
        out.println(doIt.jobCount());
        out.println("abc");
        out.print(doIt.abc());

        out.close();
    }

}
