package OOP.Basics;

public class Java_Basics {
    public static void main(String[] args) {
        arrays();
    }

    static void arrays(){
        int[] scores = new int[4];
       // int[] scores1 = new int[] {5, 6, 7, 8, 9, 1, 2, 3, 10, 12};
       //int[] scores2 = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        scores[0] = 98;
        scores[1] = 99;
        scores[2] = 97;
        scores[3] = 94;
//        for(int i = 0; i < scores.length; i++){
//            System.out.println("Midterm " + i + " score is " + scores[i]);
//        }
        System.out.println(scores.length);

        Student[] students = new Student[5];
        Student[] students1 = {new Student(), new Student(), new Student()};
        students[0] = new Student();
        students[0].name = "MayaSan";
        System.out.println("Student 1: " + students[0].name);

    }
}

class Student {
    // instance vs static variables
    // fields => instant variables
    static int computeCount = 0;
    int id1 ;
    String name;
    String gender;
    int age;
    long phone ;
    double gpa ;
    char degree ;

    boolean international;
    double tuitionFees = 12000.0, internationalFees = 5000.0;

    void compute(){
        // local variables needs to be initialised to get default values
        computeCount +=1;
        int nextId = id1+ 1;
        if (international){
            tuitionFees += internationalFees;
        }
        System.out.println("\nId : " + id1);
        System.out.println("Student Name : " + name);
        System.out.println("NextId : " + nextId);
        System.out.println("Age: "+ age);
        System.out.println("Phone : "+ phone);
        System.out.println("GPA : "+ gpa);
        System.out.println("Degree: " + degree);
        System.out.println("Tuition Fees: "+ tuitionFees);
        System.out.println("Compute count : " + computeCount);

    }

}

/*
//*************************************************************
// Object and Classes
//*************************************************************

class Student {
    // variables (like containers)
    int  id;
    String name;
    String gender;

    // method definitions
    boolean updateProfile(String newName){
        this.name = newName;
        return true;
    }
}

        Student student1 = new Student();
        student1.name = "Mary";
        student1.gender = "Female";
        student1.id = 1001;
        System.out.println(student1.updateProfile("Joan"));

//*************************************************************
// Basics Demo
//*************************************************************
 class, interface, enum, abstract, implements, extends, this, super,
 byte, short, char, int, long, float, double, boolean
 break, continue, for, do, while, if , else, new switch, default, case, goto
 try, catch, final , assert, throw, throws
 package, import,
 public, private, protected
 synchronised, instanceof, return, transient, static, void, finally, volatile, constant, native


     Student s1 = new Student();
        s1.id1 = 1000; // object reference
                s1.name = "SuSan";
                s1.gender = "Female";
                s1.age = 18;
                s1.phone = 223_456_789L;
                s1.gpa = 3.8;
                s1.degree = 'B';
                s1.international = false;
                s1.compute();

                Student s2 = new Student();
                s2.id1 = 1000;
                s2.name = "Bobyun";
                s2.gender = "Male";
                s2.age = 18;
                s2.phone = 223_456_789L;
                s2.gpa = 3.4;
                s2.degree = 'M';
                s2.international = true;
                s2.compute();


                System.out.println("Student.computerCount : " + Student.computeCount);




//*************************************************************
// Type Casting
//*************************************************************
- smaller to larger - widening conversion
-         int x = 65;
        long y = x; // implicit casting by compiler
        // byte (8 bit) -> short ( 16 bit) -> int (32 bit) -> long (64 bit)
        // -> float (32 bit) -> double (64)
        long a = 42;
        int b = (int) a;
        // out of range assignments
        // truncation
        // float to int/ char will always truncate
        int c = (int) 3.14f;
        int d = (int) 0.9;
        double average = (double) (2+3)/2;
        System.out.println(average);
//*************************************************************
// Statement Types
//*************************************************************
- declaration statement
    - int count = 25;

- expression statement
    - count = 25;
    - getCount();
    - count++
- control flow statements
    if (count < 100) {

        ...
    }

//*************************************************************
// Arrays
//*************************************************************
 Array - container object that holds fixed #values of single type


 */








