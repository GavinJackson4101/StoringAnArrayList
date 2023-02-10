import java.util.ArrayList;

import java.util.Comparator;

import java.util.Random;

class Student {

    int rollno;

    String name;

    String address;

    public Student(int rollno, String name, String address) {

        super();

        this.rollno = rollno;

        this.name = name;

        this.address = address;

    }

    @Override

    public String toString() {

        return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";

    }

}

class Sortbyroll implements Comparator<Student>

{

// Used for sorting in ascending order of

// roll number

    public int compare(Student a, Student b)

    {

        return a.rollno - b.rollno;

    }

}

class Sortbyname implements Comparator<Student>

{

// Used for sorting in ascending order of

// roll name

    public int compare(Student a, Student b)

    {

        return a.name.compareTo(b.name);

    }

}
class main {

    public static void sort(ArrayList<Student> students)

    {

        Sortbyroll sortbyroll = new Sortbyroll();

        int n = students.size();

// One by one move boundary of unsorted subarray

        for (int i = 0; i < n-1; i++)

        {

// Find the minimum element in unsorted array

            int min_idx = i;

            for (int j = i+1; j < n; j++)

                if (sortbyroll.compare(students.get(j), students.get(min_idx)) < 0)

                    min_idx = j;

// Swap the found minimum element with the first

// element

            Student temp = students.get(min_idx);

            students.set(min_idx, students.get(i));

            students.set(i, temp);

        }

    }

    public static void main(String[] args) {

        Random rand = new Random();

        ArrayList<Student> students = new ArrayList<>();

        for (int i=0; i<10; i++) {

            int roll = rand.nextInt(100);

            String name = "Name" + i;

            String address = "Address" + i;

            students.add(new Student(roll, name, address));

        }

        sort(students);

        System.out.println("The sorted students are:");

        for (Student s : students) {

            System.out.println(s);

        }

    }

}