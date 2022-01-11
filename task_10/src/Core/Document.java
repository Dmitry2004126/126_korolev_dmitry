package Core;

import java.util.HashMap;

public class Document {
    private String date;
    private HashMap<Integer, PaymentDoc> paymentDocs;
    public Document(String date){
        this.date = date;
        paymentDocs = new HashMap<>();

    }
    public void registerPaymentDoc(int sum, int number, String date){
        paymentDocs.put(number, new PaymentDoc(sum,date));
    }
    public int getPaymentDoCount(){
        return paymentDocs.size();
    }
}
