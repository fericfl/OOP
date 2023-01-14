import java.util.ArrayList;

class Employee {
    protected String name;
    protected int CNP;
    protected double salary;

    public Employee(String name,int CNP) {
        this.name = name;
        this.CNP = CNP;
    }

    public boolean equals(Object employee) {
        if(employee instanceof Employee)
            if(name.equals(((Employee)employee).name) && (CNP == (((Employee)employee).CNP)))
                return true;
        return false;
    }
}

class PermanentEmployee extends Employee {
    protected double salary;
    public PermanentEmployee (String name, int CNP,double salary) {
        super(name,CNP);
        this.salary = salary;
    }
}

class HourlyEmployee extends Employee {
    protected int workHours;
    protected int rate;

    public HourlyEmployee (String name, int CNP, int rate) {
        super(name,CNP);
        workHours = getWorkHours(rate);
        salary = getSalary();
    }

    public int getWorkHours(int workHours) {
        return workHours;
    }

    public double getSalary() {
        return rate * workHours;
    }
}

class AlreadyInList extends Exception {
    public AlreadyInList() {
        super("Already in Company");
    }
}

class Company {

    ArrayList<Employee> team = new ArrayList<>();

    public void addEmployee(Employee employee) throws AlreadyInList{
        /*if(team.contains(employee))
            return false;
        team.add(employee);
        return true;*/

            if(team.contains(employee))
                throw new AlreadyInList();
            team.add(employee);
    }

    public String printCompany() {
        String aux = "";
        for(int i = 0; i < team.size(); i++) {
            aux += team.get(i) + "\n";
        }
        return aux;
    }
}

class ProblemCompany {
    public static void main(String[] args) {
        Company c1 = new Company();
        Employee e1 = new PermanentEmployee("Andrei", 88877666, 1444);
        Employee e2 = new PermanentEmployee("Andrei", 88877666, 1444);
        Employee e4 = new PermanentEmployee("Andrei", 88877666, 1444);
        Employee e3 = new HourlyEmployee("Ghita", 9991023, 123);
        try {
            c1.addEmployee(e1);
        } catch (AlreadyInList e) {
            System.out.println(e.getMessage());
        }

        try {
            c1.addEmployee(e2);
            c1.addEmployee(e4);
        } catch (AlreadyInList e) {
            System.out.println(e.getMessage());
        }

        try {
            c1.addEmployee(e3);
            
        } catch (AlreadyInList e) {
            System.out.println(e.getMessage());
        }
        
        
    }    
}
