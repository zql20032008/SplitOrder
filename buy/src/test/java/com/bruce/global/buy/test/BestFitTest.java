package com.bruce.global.buy.test;

import java.util.ArrayList;
import java.util.List;

import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;
import com.bruce.global.buy.splitorder.fit.BestFitStrategy;

public class BestFitTest extends BaseTestCase {

    public void execute() {

        List<Item> items = new ArrayList<Item>();

        /*  items.add(new Item("item0", 3));
          items.add(new Item("item1", 5));
          items.add(new Item("item2", 2));
          items.add(new Item("item3", 4));
          
          BinPacking bp = new BinPacking(10);*/

        items.add(new Item("item0", 350));
        items.add(new Item("item1", 300));
        items.add(new Item("item2", 200));
        items.add(new Item("item3", 200));
        items.add(new Item("item4", 600));
        items.add(new Item("item5", 350));

        /*  items.add(new Item("item0", 60));
          items.add(new Item("item1", 120));
          items.add(new Item("item2", 150));
          items.add(new Item("item3", 400));
          items.add(new Item("item4", 430));
          items.add(new Item("item5", 820));*/

        /* items.add(new Item("item0", 60));
         items.add(new Item("item1", 120));
         items.add(new Item("item2", 150));
         items.add(new Item("item3", 300));
         items.add(new Item("item4", 200));
         items.add(new Item("item5", 450));
         items.add(new Item("item6", 200));
         items.add(new Item("item7", 250));
         items.add(new Item("item8", 480));
         items.add(new Item("item9", 450));
         items.add(new Item("item10", 150));
         items.add(new Item("item11", 200));
         items.add(new Item("item12", 250));
         items.add(new Item("item13", 480));
         items.add(new Item("item14", 450));
         items.add(new Item("item15", 150));
         items.add(new Item("item16", 150));
         items.add(new Item("item17", 200));
         items.add(new Item("item18", 250));
         items.add(new Item("item19", 480));*/

        long begin = System.currentTimeMillis();

        BestFitStrategy strategy = new BestFitStrategy(1000);
        List<Bin> binList = strategy.pack(items);
        long elapseTime = System.currentTimeMillis() - begin;
        System.out.println("elapse:" + elapseTime + " ms");
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
