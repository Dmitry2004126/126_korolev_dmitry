import org.junit.Assert;
import org.junit.Test;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void QuickSort_sortUnsortedArray_ArrayIsSorted(){
        Integer[] Array = new Integer[]{2,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, Array);
    }
    @Test
    public void QuickSort_ArrayWithTwoUnsortedNumbers_ArrayIsSorted(){
        Integer[] Array = new Integer[]{1,2,4,3,5};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4, 5}, Array);
    }
    @Test
    public void QuickSort_HugeUnsortedArray_ArrayIsSorted(){
        Integer[] Array = new Integer[]{9,8,7,6,5,4,3,2,1,0};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0,1,2,3,4,5,6,7,8,9}, Array);
    }
    @Test
    public void QuickSort_ArrayWithTwoEqualNumbers_ArrayIsSorted() {
        Integer[] Array = new Integer[]{1, 4, 1, 2};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 2,4}, Array);
    }

    @Test
    public void MergeSort_sortUnsortedArray_ArrayIsSorted(){
        Integer[] Array = new Integer[]{2,1};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, Array);
    }
    @Test
    public void MergeSort_ArrayWithFirstUnsortedElem_ArrayIsSorted(){
        Integer[] Array = new Integer[]{5,4,6};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{4,5,6}, Array);
    }
    @Test
    public void MergeSort_UnsortedArrayWithTwoEqualsNumbers_ArrayIsSorted(){
        Integer[] Array = new Integer[]{1,3,2,1};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,3}, Array);
    }
    @Test
    public void MergeSort_ArrayWithTwoPairsOfEqualsNumbers_ArrayIsSorted(){
        Integer[] Array = new Integer[]{1,5,2,5,3,2};
        MergeSort<Integer> ms = new MergeSort();
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,2,3,5,5}, Array);
    }

    @Test
    public void HeapSort_SortUnsortedArray_ArrayIsSorted(){
        Integer[] Array = new Integer[]{2,1};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, Array);
    }
    @Test
    public void HeapSort_SortSortedArray_ArrayIsTheSame(){
        Integer[] Array = new Integer[]{1,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, Array);
    }
    @Test
    public void HeapSort_SortUnsortedArrayWithFiveNumbers_ArrayIsSorted(){
        Integer[] Array = new Integer[]{2,4,1,3,5};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4,5}, Array);
    }
    @Test
    public void HeapSort_UnsortedArray_ArrayIsSorted(){
        Integer[] Array = new Integer[]{4,2,1,2,1,3};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,2,3,4}, Array);
    }

    @Test
    public void HeapSort_SortUnsortedArray2_ArrayIsSorted(){
        Integer[] Array = new Integer[]{8,3,6,7,3,8,8,6};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{3,3,6,6,7,8,8,8}, Array);
    }



}
