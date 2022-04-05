import org.junit.*;

public class Task2_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    private boolean isSorted(Integer[] data){
        for(int i=0; i<data.length-1; i++){
            if(data[i]>data[i+1])
                return false;
        }
        return true;
    }
    @Test
    public void BubbleSort_ArrayWithThreeSimilarElements_ArrayIsTheSame(){
        Integer[] data={10,10,10};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{10, 10,10}, data);
    }
    @Test
    public void BubbleSort_SortedArray_ArrayIsTheSame(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,2,3,4};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }
    @Test
    public void BubbleSort_UnSortedArray_ArrayIsSorted(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,4,3,2};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }
    @Test
    public void SelectionSort_ArrayWithTheFirstMaxElem_ArrayIsSorted(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2,4,5}, data);
    }
    @Test
    public void SelectionSort_UnsortedArrayWithTwoElements_ArrayIsSorted(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void SelectionSort_UnsortedArray_ArrayIsSorted(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,1,2,3};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, data);
    }
    @Test
    public void InsertionSort_SortedArray_ArrayIsTheSame(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={4,5};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    @Test
    public void InsertionSort_UnsortedArray_ArrayIsSorted(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={5,4};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{4,5}, data);
    }
    
}
