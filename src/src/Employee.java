package src;

public class Employee
{

    private String job;
    private double salary;

    public Employee()
    {

    }
    public Employee(String job, double salary)
        {
            this.job = job;
            this.salary = salary;
        }
        public String getJob()
        {
            return job;
        }
        public double getSalary()
        {
            return salary;
        }
}
