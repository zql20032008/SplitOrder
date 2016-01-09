package com.bruce.global.buy.splitorder.domain;

import java.util.ArrayList;


/**
 * @author bruce.zql
 * �������ݽṹ
 *
 */
public class Bin {

    private int             capacity; //�ܷŶ���

    private int             size;    //�Ѿ����˶���

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
