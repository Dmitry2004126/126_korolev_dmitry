import org.junit.Assert;
import org.junit.*;

public class Task2_Tests extends Assert {
    static class TestComparator implements MyComparator<Integer>{

        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }

    }
    private boolean isSorted(Integer[] data){
        for(int i =0 ; i < data.length-1; ++i){
            if( data[i] > data[i +1])
                return false;
        }
        return true;
    }


    @Test
    public void BubbleSort_someDataWithSimilarElements_DataIsTheSame(){
        Integer[] data={2,2,2,2,2,2};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2, 2,2,2,2,2}, data);
    }
    @Test
    public void BubbleSort_SortedData_DataIsTheSame(){
        Integer[] data={2,3,4,5};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2, 3,4,5}, data);
    }
    @Test
    public void BubbleSort_UnsortedData_SortOK(){
        Integer[] data={5,4,3,1};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,3,4,5}, data);
    }
    @Test
    public void SelectionSort_UnsortedDataWithFirstMaxElem_SortOK() {
        Integer[] data = {3, 2, 1};
        SelectionSort<Integer> ss = new SelectionSort<>();
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2,3}, data);
    }


    @Test
    public void SelectionSort_UnsortedDataWithTwoElem_SortOK(){
        Integer[] data={3,1};
        SelectionSort<Integer> bs = new SelectionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,3}, data);
    }
    @Test
    public void SelectionSort_UnsortedData_SortOK(){
        Integer[] data={3,1,5,7};
        SelectionSort<Integer> bs = new SelectionSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,3,5,7}, data);
    }
    @Test
    public void InsertionSort_SortedData_SortOK(){
        Integer[] data={1,2,3};
        InsertionSort<Integer> is = new InsertionSort<>();
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3}, data);
    }
    @Test
    public void InsertionSort_UnsortedDataWithFirstMaxElem_SortOK() {
        Integer[] data = {3,1};
        InsertionSort<Integer> is = new InsertionSort<>();
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 3}, data);
    }

}
