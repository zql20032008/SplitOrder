package com.bruce.global.buy.test;

import java.util.ArrayList;
import java.util.List;

import com.bruce.global.buy.splitorder.SplitOrderFacade;
import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;

public class SplitOrderTest extends BaseTestCase {

    public void execute() {

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("item0", 350));
        items.add(new Item("item1", 300));
        items.add(new Item("item2", 200));
        items.add(new Item("item3", 200));
        items.add(new Item("item4", 600));
        items.add(new Item("item5", 350));

        long begin = System.currentTimeMillis();
        
        SplitOrderFacade bp = new SplitOrderFacade(1000);

        List<Bin> resultList = bp.pack(items);

        long elapseTime = System.currentTimeMillis() - begin;
        
        System.out.println("elapse:" + elapseTime + " ms");

        for (Bin solution : resultList) {
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
