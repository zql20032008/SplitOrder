package com.bruce.global.buy.splitorder.domain;

import java.util.ArrayList;


/**
 * @author bruce.zql
 * 箱子数据结构
 *
 */
public class Bin {

    private int             capacity; //能放多少

    private int             size;    //已经放了多少

    private ArrayList<Item> contents;

    public Bin(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        contents = new ArrayList<Item>();
    }

    public boolean addItem(Item item) {
        if (size + item.getSize() > capacity) {
            return false;
        }
        contents.add(item);
        size += item.getSize();
        return true;
    }

    @Override
    public String toString() {
        return "Bin [capacity=" + capacity + ", size=" + size + ", contents=" + contents + "]";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Item> getContents() {
        return contents;
    }
    
    public int getRemain(){
        return capacity-size;
    }
    

}
