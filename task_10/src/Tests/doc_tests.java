package Tests;

import Core.DocBook;
import org.junit.*;

public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        assertEquals(0,docBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNumberAndDate_DocCountEqualsOne(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "20220111");
        assertEquals(1, docBook.getDocCount());
    }

}
