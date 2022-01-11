package Tests;

import Core.DocBook;
import Core.TypeOfPaymentDoc;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class doc_tests extends Assert {
    @Test
    public void create_CreateEmptyDocBook_DocCountEqualsZero() {
        DocBook docBook = DocBook.create();
        assertEquals(0, docBook.getDocCount());
    }

    @Test
    public void addDoc_addDocWithNumberAndDate_DocCountEqualsOne() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");
        assertEquals(1, docBook.getDocCount());
    }

    @Test
    public void addDoc_addDocWithNullNumber_ThrowsException() {
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc(null, "date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null"));
    }

    @Test
    public void addDoc_addDocWithNullDate_ThrowsException() {
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc("number", null));
        assertTrue(exc.getMessage().toLowerCase().contains("date cannot be null"));
    }

    @Test
    public void addDoc_addDocWithNullNumberAndNullDate_ThrowsException() {
        DocBook docBook = DocBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> docBook.addDoc(null, null));
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null") &&
                exc.getMessage().toLowerCase().contains("date cannot be null"));
    }

    @Test
    public void registerPaymentDoc_registerPayDocWithoutData_PaymentDoCountEqualsZero() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");
        assertEquals(0, docBook.getDocs().get("number").getPaymentDocCount());

    }

    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsOne() {
        DocBook docBook = DocBook.create();

        docBook.addDoc("number", "date");
        docBook.registerPaymentDoc(100, 01, "number", TypeOfPaymentDoc.BankOrder, "date");
        assertEquals(1, docBook.getDocs().get("number").getPaymentDocCount());
    }

    @Test
    public void registerPaymentDoc_registerPayDocWithData_PaymentDocCountEqualsThree() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");
        docBook.registerPaymentDoc(100, 01, "number", TypeOfPaymentDoc.PaymentOrder, "20000101");
        docBook.registerPaymentDoc(200, 02, "number", TypeOfPaymentDoc.PaymentOrder, "20000202");
        docBook.registerPaymentDoc(300, 03, "number", TypeOfPaymentDoc.PaymentOrder, "20000303");
        assertEquals(3, docBook.getDocs().get("number").getPaymentDocCount());

    }

    @Test
    public void registerPaymentDoc_registerPayDocWithSumLessThenZero_TrowsException() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                docBook.registerPaymentDoc(-100, 01, "number", TypeOfPaymentDoc.PaymentOrder, "20030204"));
        assertTrue(exc.getMessage().toLowerCase().contains("sum is a positive number"));
    }

    @Test
    public void registerPaymentDoc_registerPayDocWithPaymentDocNumberLessThenZero_TrowsException() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");

        var exc = assertThrows(IllegalArgumentException.class, () ->
                docBook.registerPaymentDoc(100, -7, "number", TypeOfPaymentDoc.PaymentOrder, "20030204"));
        assertTrue(exc.getMessage().toLowerCase().contains("number of payment document is a positive number"));
    }

    @Test
    public void getList_getListOfAllPayments_equalLists() {
        DocBook docBook = DocBook.create();
        docBook.addDoc("number", "date");
        docBook.registerPaymentDoc(100, 01, "number", TypeOfPaymentDoc.PaymentOrder, "20030204");
        docBook.registerPaymentDoc(500, 02, "number", TypeOfPaymentDoc.BankOrder, "20030204");
        docBook.registerPaymentDoc(300, 03, "number", TypeOfPaymentDoc.PaymentOrder, "20030204");

        List<Integer> paymentDocs = new ArrayList();
        paymentDocs.add(100);
        paymentDocs.add(500);
        paymentDocs.add(300);

        assertArrayEquals(paymentDocs.toArray(), docBook.getAllPayments().toArray());

    }
    @Test
    public void deletePaymentDoc_DeletePaymentDocWithDocNumberNumberAndDate_PaymentsCountEqualsZero(){
        DocBook docBook = DocBook.create();
        docBook.addDoc("number","20110825");
        docBook.registerPaymentDoc(100,2, "number", TypeOfPaymentDoc.PaymentOrder,"20110919");
        docBook.registerPaymentDoc(100,1, "number", TypeOfPaymentDoc.PaymentOrder,"20150321");

        docBook.deletePayment( "number", 2, "20110919");
        docBook.deletePayment( "number", 1, "20150321");
        assertEquals(0, docBook.getDocs().get("number").getPaymentDocCount());
    }
}
