package simplejavaapps.Lambdas;

import java.awt.print.Printable;
import java.util.function.Consumer;

public class Lambda {

    public void DisplayMessage(String message)
    {
       Displayable d = (st)->{System.out.println("HELLO " +st);};
       d.display(message);
    }


    @FunctionalInterface
    public interface Voidable{
        void show();
    }

    @FunctionalInterface
    public interface Displayable {
        void display(String text);
    }

    @FunctionalInterface
    public interface Addable{
        int add(int x1, int x2);
    }

    public static void displaySomething(Displayable d, String s) {
        d.display(s + " !");

    }

    public static void doIt(String[] args) {

        Displayable d = (m) -> {
            System.out.println("This is lambda: "+m);
        };

        d.display("just displaying this message (passed to lambda as single parameter)");

        // use method with predefined lambda object as parameter
        displaySomething(d, "lambda object passed as parameter and this text passed as parameter to method \"displaySomething\"");

        // use method with lambda as parameter (new Displayable object is created)
        //it creates new Displayable object and overrides its display method with lambda expression
        //then it pass second parameter of method displaySomething to overriden method display
        displaySomething((st) -> { System.out.println("This is lambda: "+ st);}, "lambda expression passed as parameter and this text passed as parameter (\"st\") to method \"displaySomething\"");




        // two parameters adding
        Addable a = (r1,r2)->{
            int x = r1+r2;
            System.out.println("This is result of lambda adding two parameters: " + x);
            return x;
        };
        a.add(2,4);


        // no parameters
        Voidable v1 = ()->{System.out.println("This is lambda without parameter so this message is fully passed as Overriden Voidable interface show() method");};
        v1.show();

        // lambda without parameters as anonymous class for comparison
        Voidable v2 = new Voidable() {
            @Override
            public void show() {
                System.out.println("This is anonymous class without parameter so this message is fully passed as Overriden Voidable interface show() method");
            }
        };
    }

}
