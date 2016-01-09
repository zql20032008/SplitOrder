package com.bruce.global.buy.splitorder.fit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bruce.global.buy.splitorder.Strategy;
import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;

/**
 * @author bruce.zql
 * 最佳适合递减算法
 *
 */
public class BestFitStrategy implements Strategy {

    private int capacity;

    List<Bin>   orderList = new ArrayList<Bin>();

    public BestFitStrategy(int capacity) {
        super();
        this.capacity = capacity;
    }

    public List<Bin> pack(List<Item> items) {

        Collections.sort(items);
        Collections.reverse(items);

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            //只考虑比箱子小或者等于的物品

            if (item.getSize() <= capacity) {

                if (orderList.isEmpty()) {
                    Bin bin = new Bin(capacity);
                    bin.addItem(item);
                    orderList.add(bin);

                } else {
                    int min = 0;
                    Bin selectedBin = null;
                    for (Bin bin : orderList) {
                        //能够放物品，而且能放当前物品的箱子有哪些？
                        if (bin.getRemain() > 0 && bin.getRemain() >= item.getSize()) {
                            if (item.getSize() - bin.getRemain() < min) {
                                min = item.getSize() - bin.getRemain();
                                selectedBin = bin;
                            }
                        }

                    }
                    //找到符合要求的bin
                    if (selectedBin != null) {
                        selectedBin.addItem(item);

                    } else {
                        Bin bin = new Bin(capacity);
                        bin.addItem(item);
                        orderList.add(bin);

                    }
                }

            }

        }

        return orderList;

    }

    public static void main(String[] args) {

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("item0", 60));
        items.add(new Item("item1", 120));
        items.add(new Item("item2", 150));
        items.add(new Item("item3", 400));
        items.add(new Item("item4", 430));
        items.add(new Item("item5", 820));
        BestFitStrategy strategy = new BestFitStrategy(1000);
        List<Bin> binList= strategy.pack(items);
        for (Bin solution : binList) {
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            for (Item item : solution.getContents()) {
                builder.append(item.getSize());
                builder.append(",");
            }
            if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("}");
          
            System.out.println(builder.toString());
        }
    }

}
