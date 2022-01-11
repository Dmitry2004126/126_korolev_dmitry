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
        docCount++;
    }
}
