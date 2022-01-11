package Tests;

import org.junit.*;

public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        assertEquals(0,docBook.getDocCount());
    }

}
