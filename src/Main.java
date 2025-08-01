import java.awt.print.Book;
import java.util.*;
// Show me your attempt - don't worry if it's wrong
   class Person {
      // I created final int to avoid assigning it new value;
      private static final int MIN_AGE = 0;
      private static final int MAX_AGE = 150;

    // Your code here
    private String name;
    private int age;

    Person(String name, int age) {
        validateName(name);
        validateAge(age);
        this.name = name.trim();
        this.age = age;
    }

    private void validateName(String name) {
       if(name == null) {
           throw new IllegalArgumentException("Name should not null");
       } else if (name.trim().isBlank()) { // idk what this means, explain it later like, does i mean if name is trimmed and is not blank
           throw new IllegalArgumentException("The name should not blank");
       }
    }

    private void validateAge(int age) {
        // Your implementation
        if(age < MIN_AGE) {
            throw new IllegalArgumentException("The age should not be negative");
        } else if (age > MAX_AGE) {
            throw new IllegalArgumentException("The age should not exceed to 150");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Helllo, I am " + name + ", and I am " + age + " years old.");
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}



public class Main {
    public static void main(String[] args) {
            // Test 1: Valid person
            try {
                Person person1 = new Person("John", 25);
                System.out.println("Valid person created: " + person1);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Test 2: Null name
            try {
                Person person2 = new Person(null, 25);
                System.out.println("This should not print");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught null name error: " + e.getMessage());
            }

            // Test 3: Blank name
            try {
                Person person3 = new Person("   ", 25);
                System.out.println("This should not print");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught blank name error: " + e.getMessage());
            }

            // Test 4: Negative age
            try {
                Person person4 = new Person("Mary", -5);
                System.out.println("This should not print");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught negative age error: " + e.getMessage());
            }

            // Test 5: Age too high
            try {
                Person person5 = new Person("Bob", 200);
                System.out.println("This should not print");
            } catch (IllegalArgumentException e) {
                System.out.println("Caught high age error: " + e.getMessage());
            }
        }


}