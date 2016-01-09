package com.bruce.global.buy.test;

import junit.framework.TestCase;

public abstract class BaseTestCase extends TestCase {
    
    public void testCase1(){
       
        execute();
      
    }
    
    public abstract void execute();

}
