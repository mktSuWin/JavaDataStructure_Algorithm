package OOP.Basics;

import java.awt.desktop.AboutEvent;

public class Java_Basics_Methods {
    public static void main(String[] args) {
        int result = methodName(3,4);
        System.out.println(sum(3.4f, -56.9));
        System.out.println(average(3.4, 8.9));
        int[] list = { 2, 3, 4, 5};
        System.out.println(search(list, 12));
    }

    public static int methodName(int i, int j){
        int result = 0;
        return result;
    }

    public static double sum(double i , double j){
        return i + j;
    }

    // Methods promote software re-use
    // Methods avoid duplication
    public static double average(double i , double j){
        double sum = sum(i, j);
        return sum/2;
    }

    static boolean search (int[] list, int key){
        return true;
    }
}

/*
Software business logic
Algorithmic logic

arguments or actual parameters
invoke method
                              arguments
        type var = methodName(arg1, arg2);

        caller ---input--> method
        Method signature
        =================
                                    parameters
        returnType methodName(type para1, type para2) {
            return someValue;
        }

   Return type
   - void - nothing to return
   - return; as a last statement
   - return type is mandatory, array, class, interface or void
   - If other than void, you must return

Method types
instant
    - It is a class level method, object level.
    - Can be accessed by objectReference.methodName()
    - affect object state
    - instant variables (object states)
    - Other instance methods
Static methods
    - What static methods are?
    - keyword - static , if you don't use it, it is instant method
    - It does not deal with object state.
    - no access to state
    - Serve as utility method e.g. sum( double x, double y) { }
    - Typically dependent on the parameters
    - they can access static variables (class level variable)
    - Can access other static methods of the same class
    - className.methodName()
    - main method is static.


Accessibility of static methods
-------------------------------
    - cannot directly access instant variables/ methods defined in the same class
    - can directly access static variables/ methods defined in the same class
    - can access anything via an object reference. So from a static method by using an object reference, we can access instance variables, methods


Accessibility of instant methods
---------------------------------
    - can access anything from an instance method. So we can even access static variables/ methods defined in the same class as the instance method
 */
