package com.bruce.global.buy.splitorder;

import java.util.List;

import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;

public interface Strategy {
    
     List<Bin> pack( List<Item>  items) ;

}
