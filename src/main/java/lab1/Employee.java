package lab1;

public class Employee {
    private int id;
    private static int nextId;
    private String name;
    private String surName;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FieldLengthLimitException {
        if (name.length() > 10) throw new FieldLengthLimitException("Name dlinne");
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) throws FieldLengthLimitException {
        if (surName.length() > 10) throw new FieldLengthLimitException("Surname dlinne");
        this.surName = surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if(salary<0) throw new IncorrectSalaryException("Negative dengi");
        this.salary = salary;
    }
}
