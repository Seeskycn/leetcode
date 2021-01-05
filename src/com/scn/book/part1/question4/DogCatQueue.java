package com.scn.book.part1.question4;

import java.util.Queue;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-03
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    /**
     * 计数器
     */
    private Long count;

    public DogCatQueue(Queue<PetEnterQueue> dogQ, Queue<PetEnterQueue> catQ, Long count) {
        this.dogQ = dogQ;
        this.catQ = catQ;
        this.count = count;
    }

    public void add(Pet pet){
        if(pet.getType().equals("Dog")){
            dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getType().equals("Cat")){
            catQ.add(new PetEnterQueue(pet,this.count++));
        }else{
            throw new RuntimeException("not dog or cat");
        }
    }

    public Pet poll(){
        if(!this.dogQ.isEmpty()&&!this.catQ.isEmpty()){
            if(this.dogQ.peek().getCount()<this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            }else{
                return this.catQ.poll().getPet();
            }
        }else if(this.catQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if(this.dogQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            return null;
        }
    }

    public Dog pollDog(){
        if (this.dogQ.isEmpty()) {
            return null;
        }else{
            return (Dog) this.dogQ.poll().getPet();
        }
    }

    public Cat pollCat(){
        if (this.catQ.isEmpty()) {
            return null;
        }else{
            return (Cat) this.catQ.poll().getPet();
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }
    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }
    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}
