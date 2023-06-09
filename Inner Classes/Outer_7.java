// Program-7
// Anonymous Inner Class

class Employee
{
    void salary()
    {
        System.out.println("Employee Basic Salary");
    }
}

class Outer_7
{
    public static void main(String[] args)
    {
        Employee e1,e2,e3;
        e1 = new Employee();
        e2 = new Employee();
        e3 = new Employee();
        e1.salary();
        e2.salary();

        Employee e = new Employee()
        {
            void salary()
            {
                System.out.println("--- Anonymous Class ---");
            }
        };

        e.salary();

        e3.salary();
    }
}