import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void QuickSort_SortUnsortedArray_ArrayIsSorted(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] Array = {1, 3, 2};
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, Array);
    }
    @Test
    public void QuickSort_QuickSortHugeUnsortedArray_ArrayIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] Array = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        qs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, Array);
    }
    @Test
    public void MergeSort_SortSortedArray_ArrayIsSame(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] Array = {1, 2, 3};
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, Array);
    }

    @Test
    public void MergeSort_SortUnsortedArray_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] Array = {1, 3, 2};
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, Array);
    }

    @Test
    public void MergeSort_SortHugeUnsortedArray_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] Array = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, Array);
    }

    @Test
    public void MergeSort_SortArrayWithNegativeElems_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] Array = {1, 0, -1};
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, Array);
    }
    @Test
    public void MergeSort_SortHugeUnsortedArrayWithSameElems_ArrayIsSorted(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] Array = {0, 0, 1, 2, 2, 1, 2};
        ms.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0, 0, 1, 1, 2, 2, 2}, Array);
    }


    @Test
    public void HeapSort_SortUnsortedArrayWithTwoElems_ArrayIsSorted(){
        Integer[] Array = new Integer[]{3,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{2, 3}, Array);
    }

    @Test
    public void HeapSort_SortSortedArray_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] Array = {1, 2, 3};
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, Array);
    }



    @Test
    public void HeapSort_SortHugeUnsortedArray_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] Array = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, Array);
    }

    @Test
    public void HeapSort_HSortHugeUnsortedArrayWithSameElems_ArrayIsSorted(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] Array = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4, 1};
        hs.sort(Array, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, Array);
    }







}
