package org;

import org.proxy1.BookServiceImpl;
import org.junit.Test;


public class MyTest1 {
    @Test
    public void test(){
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.buy();
    }


}
