package Core;

import java.util.HashMap;

public class DocBook {
    private HashMap<String, String> docBook;
    private DocBook(){
        docBook= new HashMap<>();
    }
    public int getDocCount(){
        return docBook.size();
    }
    public static DocBook create(){
        return new DocBook();
    }

    public void addDoc(String number, String date) {
       StringBuilder error = new StringBuilder();
        if(number == null){
           error.append("Number cannot be null\n");
        }
        if (date == null){
            error.append("Date cannot be null\n");

        }
        if (!error.isEmpty()){
            throw new IllegalArgumentException(error.toString());
        }

        else {
            docBook.put(number, date);
        }
    }
}
