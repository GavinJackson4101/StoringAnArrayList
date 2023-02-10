import java.util.ArrayList;
import java.util.Random;

public class Main {
    // it is used for sorting
    public static void sort(ArrayList<Student> students)

    {

        Sortbyroll sortbyroll = new Sortbyroll();
// size of student
        int n = students.size();


// to iterate
        for (int ii = 0; ii < n-1; ii++)

        {



            int min_idx = ii;

            for (int j = ii+1; j < n; j++)

                if (sortbyroll.compare(students.get(j), students.get(min_idx)) < 0)

                    min_idx = j;


            Student temp = students.get(min_idx);

            students.set(min_idx, students.get(ii));

            students.set(ii, temp);

        }

    }

    public static void main(String[] args) {
//to create random numbers
        Random rand = new Random();

        ArrayList<Student> students = new ArrayList<>();

        for (int ii=0; ii<10; ii++) {

            int rollNumber = rand.nextInt(100);

            String nameStudent = "Name" + ii;

            String addrStudent = "Address" + ii;

            students.add(new Student(rollNumber, nameStudent, addrStudent));

        }
// sort the student
        sort(students);

        System.out.println("The sorted list of 10 students are:");
// iterate students
        for (Student s : students) {

            System.out.println(s);

        }

    }

}