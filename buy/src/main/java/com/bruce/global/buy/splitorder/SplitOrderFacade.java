package com.bruce.global.buy.splitorder;

import java.util.List;

import com.bruce.global.buy.splitorder.best.BinPacking;
import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;
import com.bruce.global.buy.splitorder.fit.BestFitStrategy;
import com.google.common.collect.Lists;

public class SplitOrderFacade {

    private int      capacity;

    private Strategy bestFitStrategy;

    private Strategy treeStrategy;

    public SplitOrderFacade(int capacity) {
        super();
        this.capacity = capacity;
        bestFitStrategy = new BestFitStrategy(capacity);
        treeStrategy = new BinPacking(capacity);

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Bin> pack(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return Lists.newArrayList();
        }
        if (items.size() > 6) {
            return bestFitStrategy.pack(items);

        } else {
            return treeStrategy.pack(items);
        }
    }

}
