package Core;

public class DocBook {
    private int docCount;
    private DocBook(){
        docCount=0;
    }
    public int getDocCount(){
        return docCount;
    }
    public static DocBook create(){
        return new DocBook();
    }

    public void addDoc(String number, String date) {
        if(number == null && date==null){
            throw new IllegalArgumentException("number and date cannot be null");
        }
        if(number == null){
            throw new IllegalArgumentException("number can not be null");
        }
        if (date == null){
            throw new IllegalArgumentException("date cannot be null");

        }

        docCount++;
    }
}
