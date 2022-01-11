package Core;

public class PaymentDoc {
    private int sum;
    private String date;
    public PaymentDoc(int sum, String date){
        this.sum= sum;
        this.date = date;
    }
    public int getSum(){
        return sum;
    }
}
