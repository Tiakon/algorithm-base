package cn.tiakon.java.zbook.chapter01.example04;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getType())) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if ("cat".equals(pet.getType())) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("err,not dog or cat");
        }
    }

    public PetEnterQueue pollAllPetEnterQueue() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return dogQ.poll();
            } else {
                return catQ.poll();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll();
        } else if (!catQ.isEmpty()) {
            return catQ.poll();
        } else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public PetEnterQueue pollDogPetEnterQueue() {
        if (!isDogEmpty()) {
            return dogQ.poll();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public PetEnterQueue pollCatPetEnterQueue() {
        if (!isCatEmpty()) {
            return catQ.poll();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public Pet pollAll() {
        return pollAllPetEnterQueue().getPet();
    }

    public Dog pollDog() {
        return (Dog) pollDogPetEnterQueue().getPet();
    }

    public Cat pollCat() {
        return (Cat) pollCatPetEnterQueue().getPet();
    }

    public Boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public Boolean isDogEmpty() {
        return dogQ.isEmpty();
    }

    public Boolean isCatEmpty() {
        return catQ.isEmpty();
    }

    // 生成随机名称的 Pet 数组实例
    public static PetEnterQueue[] randomArrayPet(int size) {
        if (size < 0) {
            throw new RuntimeException("Size should not less than 0...");
        }
        final PetEnterQueue[] pets = new PetEnterQueue[size];
        for (int i = 0; i < size; i++) {
            final double random = Math.random();
            if (random < 0.5) {
                pets[i] = new PetEnterQueue(new Dog(), i);
            } else {
                pets[i] = new PetEnterQueue(new Cat(), i);
            }
        }
        return pets;
    }

    // 根据指定的  Pet[] 返回 Dog[] 和 Cat[]
    public static ZookeeperV2 getZookeeper(PetEnterQueue[] pets) {
        final PetEnterQueue[] dogs = Arrays.stream(pets).filter(pet -> pet.getPet() instanceof Dog).toArray(PetEnterQueue[]::new);
        final PetEnterQueue[] cats = Arrays.stream(pets).filter(pet -> pet.getPet() instanceof Cat).toArray(PetEnterQueue[]::new);
        return new ZookeeperV2(cats, dogs);
    }


    public static void main(String[] args) {

        final DogCatQueue dogCatQueue = new DogCatQueue();

        final int size = (int) Math.random() * 1000 + 1;
        final PetEnterQueue[] queues = DogCatQueue.randomArrayPet(size);

        for (PetEnterQueue queue : queues) {
            dogCatQueue.add(queue.getPet());
        }

        final ZookeeperV2 zookeeper = DogCatQueue.getZookeeper(queues);
        final PetEnterQueue[] catQ = zookeeper.getCatQ();
        final PetEnterQueue[] dogQ = zookeeper.getDogQ();

        final double random = Math.random();
        int index = 0;
        try {
            if (random < 0.3) {
                while (!dogCatQueue.isEmpty()) {
                    Assert.assertEquals(queues[index].getCount(), dogCatQueue.pollAllPetEnterQueue().getCount());
                    index++;
                }
            } else if (random < 0.6) {
                while (!dogCatQueue.isDogEmpty()) {
                    Assert.assertEquals(dogQ[index].getCount(), dogCatQueue.pollDogPetEnterQueue().getCount());
                    index++;
                }
            } else {
                while (!dogCatQueue.isCatEmpty()) {
                    Assert.assertEquals(catQ[index].getCount(), dogCatQueue.pollCatPetEnterQueue().getCount());
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

class ZookeeperV2 {
    private PetEnterQueue[] dogQ;
    private PetEnterQueue[] catQ;

    public ZookeeperV2(PetEnterQueue[] dogQ, PetEnterQueue[] catQ) {
        this.dogQ = dogQ;
        this.catQ = catQ;
    }

    public PetEnterQueue[] getDogQ() {
        return dogQ;
    }

    public PetEnterQueue[] getCatQ() {
        return catQ;
    }
}