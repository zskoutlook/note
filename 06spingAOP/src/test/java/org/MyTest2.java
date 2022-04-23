package org;


import org.junit.Test;
import org.proxy2.BookServiceImpl;
import org.proxy2.SubBookServiceImpl;

public class MyTest2 {
    @Test
    public void test(){
        BookServiceImpl bookService = new SubBookServiceImpl();
        bookService.buy();
    }
}
