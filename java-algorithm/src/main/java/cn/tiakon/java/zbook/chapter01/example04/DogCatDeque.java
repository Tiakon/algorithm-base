package cn.tiakon.java.zbook.chapter01.example04;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DogCatDeque {

    final ArrayDeque all = new ArrayDeque<Pet>();
    final ArrayDeque catDeque = new ArrayDeque<Cat>();
    final ArrayDeque dogDeque = new ArrayDeque<Dog>();

    public void add(Pet pet) {
        if (pet == null) {
            return;
        }
        all.add(pet);
        if (pet instanceof Cat) {
            catDeque.add(pet);
        } else if (pet instanceof Dog) {
            dogDeque.add(pet);
        } else {
            throw new RuntimeException("error, is not dog or cat.");
        }
    }

    public Pet pollAll() {
        final Pet pet = (Pet) all.poll();
        if (pet instanceof Dog) {
            if (dogDeque.isEmpty()) {
                throw new RuntimeException("dogDeque.isEmpty...");
            }
            dogDeque.poll();
        } else if (pet instanceof Cat) {
            if (catDeque.isEmpty()) {
                throw new RuntimeException("catDeque.isEmpty...");
            }
            catDeque.poll();
        }
        return pet;
    }

    public Dog pollDog() {
        final Pet pet = (Pet) all.poll();
        if (pet instanceof Dog) {
            dogDeque.poll();
            return (Dog) pet;
        } else {
            final Dog pollDog = pollDog();
            all.add(pet);
            return pollDog;
        }
    }

    public Cat pollCat() {
        final Pet pet = (Pet) all.poll();
        if (pet instanceof Cat) {
            catDeque.poll();
            return (Cat) pet;
        } else {
            final Cat pollCat = pollCat();
            all.add(pet);
            return pollCat;
        }
    }

    public Boolean isEmpty() {
        return all.isEmpty();
    }

    public Boolean isDogEmpty() {
        return dogDeque.isEmpty();
    }

    public Boolean isCatEmpty() {
        return catDeque.isEmpty();
    }

    // 生成随机名称的 Pet 数组实例
    public static Pet[] randomArrayPet(int size) {
        if (size < 0) {
            throw new RuntimeException("Size should not less than 0...");
        }
        final Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            final double random = Math.random();
            if (random < 0.5) {
                pets[i] = new Dog(i);
            } else {
                pets[i] = new Cat(i);
            }
        }
        return pets;
    }

    // 根据指定的  Pet[] 返回 Dog[] 和 Cat[]
    public static Zookeeper getZookeeper(Pet[] pets) {
        final Dog[] dogs = Arrays.stream(pets).filter(Dog.class::isInstance).toArray(Dog[]::new);
        final Cat[] cats = Arrays.stream(pets).filter(Cat.class::isInstance).toArray(Cat[]::new);
        return new Zookeeper(cats, dogs);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {

            final DogCatDeque dogCatDeque = new DogCatDeque();
            final int size = (int) Math.random() * 1000 + 1;
            final Pet[] randomArrayPet = randomArrayPet(size);

            for (Pet pet : randomArrayPet) {
                dogCatDeque.add(pet);
            }

            final Zookeeper zookeeper = getZookeeper(randomArrayPet);
            final Cat[] cats = zookeeper.getCats();
            final Dog[] dogs = zookeeper.getDogs();

            final double random = Math.random();
            int index = 0;
            try {
                if (random < 0.3) {
                    while (!dogCatDeque.isEmpty()) {
                        Assert.assertEquals(randomArrayPet[index].getType(), dogCatDeque.pollAll().getType());
                        index++;
                    }
                } else if (random < 0.6) {
                    while (!dogCatDeque.isDogEmpty()) {
                        Assert.assertEquals(dogs[index].getType(), dogCatDeque.pollDog().getType());
                        index++;
                    }
                } else {
                    while (!dogCatDeque.isCatEmpty()) {
                        final String catType = cats[index].getType();
                        Assert.assertEquals(catType, dogCatDeque.pollCat().getType());
                        index++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.printf("error: random:%d index:%d %n", random, index);
                System.exit(-1);
            }
        }
    }
}

class Zookeeper {
    private final Cat[] cats;
    private final Dog[] dogs;

    public Zookeeper(Cat[] cats, Dog[] dogs) {
        this.cats = cats;
        this.dogs = dogs;
    }

    public Cat[] getCats() {
        return cats;
    }

    public Dog[] getDogs() {
        return dogs;
    }
}