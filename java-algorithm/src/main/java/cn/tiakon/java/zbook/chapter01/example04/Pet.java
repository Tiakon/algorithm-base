package cn.tiakon.java.zbook.chapter01.example04;

public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }

    public Dog(int num) {
        super("Dog" + num);
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }

    public Cat(int num) {
        super("Cat" + num);
    }
}