package Tests;

import Core.DocBook;
import org.junit.*;
import java.util.Locale;

import java.util.Locale;

public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero(){
        DocBook docBook = DocBook.create();
        assertEquals(0,docBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNumberAndDate_DocCountEqualsOne(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");
        assertEquals(1, docBook.getDocCount());
    }
    @Test
    public void addDoc_addDocWithNullNumber_ThrowsException(){
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc(null,"date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number can not be null"));
    }

}
