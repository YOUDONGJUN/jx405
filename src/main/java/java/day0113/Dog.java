package java.day0113;

import day0113.Animal;

public class Dog extends Animal {
    public Dog() {
        System.out.println("Dog() 호출");
    }

    public void makeSound() {
        System.out.println("멍멍");
    }

    public void eat() {
        System.out.println("강아지는 잡식동물입니다.");
    }

}
