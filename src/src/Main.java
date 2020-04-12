package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        Path path = Path.of("employees (2) (2).csv");

        try (Stream<String> lines = Files.lines(path);)
        {
            System.out.println("CSV file format:");
                lines.filter(line -> line.startsWith(" "))
                        .map(line -> LineToEmployee(line))
                            .collect(Collectors.groupingBy(person -> person.getJob(),
                                Collectors.summingDouble(person -> person.getSalary())))
                                    .forEach((job, sumSalary) -> System.out.println(job + ": " + df.format(sumSalary)));
        }
        catch (IOException e)
            {
                e.printStackTrace();
            }
    }
    private static Employee LineToEmployee(String line)
    {
            String[] elements = line.split(";");

            String job = Replacer(elements[3]);
            Double salary = Double.valueOf(Replacer(elements[4]));

            Employee e = new Employee(job, salary);
            return e;
    }
    private static String Replacer(String a)
    {
        a = a.replaceAll("\"", "")
                .replaceAll(" ", "")
                .replaceAll(",", ".")
                .replaceAll(",", ".");
        return a;
    }
    private static DecimalFormat df = new DecimalFormat("0.00");
}
