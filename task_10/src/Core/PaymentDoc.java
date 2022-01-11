package Core;

public class PaymentDoc {
    private int sum;
    private String date;
    private TypeOfPayment type;
    public PaymentDoc(int sum, TypeOfPayment type, String date){
        this.sum= sum;
        this.type=type;
        this.date = date;
    }

}
