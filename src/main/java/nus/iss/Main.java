package nus.iss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++){
//                    System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
//                }
//            }
//        });
//        thread1.start();

        MyRunnableImplementation RI = new MyRunnableImplementation("Task1");
        MyRunnableImplementation RI2 = new MyRunnableImplementation("Task2");
        MyRunnableImplementation RI3 = new MyRunnableImplementation("Task3");
        MyRunnableImplementation RI4 = new MyRunnableImplementation("Task4");
        MyRunnableImplementation RI5 = new MyRunnableImplementation("Task5");

//        Thread thread2 = new Thread(RI);
//        thread2.start();
//
//        Thread thread3 = new Thread(RI);
//        thread3.start();

//        ExecutorService ES = Executors.newCachedThreadPool();
//        ES.execute(RI);
//        ES.execute(RI2);
//        ES.execute(RI3);
//        ES.execute(RI4);
//        ES.execute(RI5);
//        ES.shutdown();

        MyRunnableInterface<Integer> addOperation = (a,b) -> {
            return a+b;
        };

        MyRunnableInterface<Integer> multiplyOperation = (a,b) -> {
            return a*b;
        };

        MyRunnableInterface<String> concatString = (a,b) -> {
            return a+b;
        };

        MyMessageInterface printMethod = (a) -> {
            System.out.println(a);
        };
        System.out.println("addOperation: " + addOperation.process(1,1));
        System.out.println("multiplication: " + multiplyOperation.process(5,5));
        System.out.println("concat string: " + concatString.process("lee","Joel"));
        printMethod.printMessage("hello");

        //list names of employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Jona", "Faye", 50000));
        employeeList.add(new Employee(1, "Nadia", "Atiqah", 100000));
        employeeList.add(new Employee(1, "Joel", "Lee", 2000));
        employeeList.add(new Employee(1, "Joel", "Tan", 2000));
        employeeList.add(new Employee(1, "Darren", "Sim", 50000));
        employeeList.add(new Employee(1, "WaiKay", "Leong", 88888));
        employeeList.add(new Employee(1, "PohYe", "Ang", 36000));

        System.out.println("Printing employee list: ");
        employeeList.forEach(IterateEmployee -> {
            System.out.println(IterateEmployee);
        });
        System.out.println();

        System.out.println("Printing employees that has \"Le\" in their last name: ");
        List<Employee> queryEmployeeCH = employeeList.stream().filter(IterateEmployee -> IterateEmployee.getLastName().contains("Le")).collect(Collectors.toList());
        queryEmployeeCH.forEach(IterateEmployee -> {
            System.out.println(IterateEmployee);
        });
        System.out.println();

        System.out.println("Sorting employees by first name: ");
        employeeList.sort(Comparator.comparing(Employee::getFirstName).reversed()); //.reversed() for Z->A
        //alternatively, Comparator<Employee> compare = Comparator.comparing(IterateEmployee -> IterateEmployee.getFirstName());
        //employeeList.sort(compare.reversed);
        employeeList.forEach(IterateEmployee -> {
            System.out.println(IterateEmployee);
        });
        System.out.println();

        System.out.println("Sort by first name, then sort by last name: ");
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employeeList.sort(groupByComparator);
        employeeList.forEach(IterateEmployee -> {
            System.out.println(IterateEmployee);
        });
        System.out.println();
    }
}