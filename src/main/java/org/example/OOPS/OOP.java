package org.example.OOPS;

public class OOP {
    // Definition of abstract class, interface, class, and inheritance in Java
//    public static void main(String[] args) {
//        Dog dog = new Dog();
//        dog.makeSound(); // Outputs: Woof!
//        dog.play();      // Outputs: The dog is playing.
//
//        Cat cat = new Cat();
//        cat.makeSound(); // Outputs: Meow!
//    }
    // OOP Concepts in Java
    // 1. Abstract Class: A class that cannot be instantiated and may contain abstract methods.
    // 2. Interface: A reference type in Java that can contain only constants, method signatures, default methods, static methods, and nested types.
    // 3. Class: A blueprint for creating objects, containing fields and methods.
    // 4. Inheritance: A mechanism where a new class is derived from an existing class, inheriting its fields and methods.

    // example of Abstract class
    public abstract class Animal {
        public abstract void makeSound();
    }
    // example of Interface
    public interface Pet {
        void play();
    }
    // example of Class
    public class Dog extends Animal implements Pet {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }

        @Override
        public void play() {
            System.out.println("The dog is playing.");
        }
    }
    // example of Inheritance
    public class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }
}
