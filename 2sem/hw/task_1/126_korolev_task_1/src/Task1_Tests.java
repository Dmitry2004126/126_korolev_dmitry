import org.junit.Assert;
import org.junit.Test;

public class Task1_Tests extends Assert {
    @Test
    public void getSize_getSizeOfEmptyArray_SizeEqualsZero(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }
    @Test
    public void set_setElemWithIndexEqualsSize_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.set(3, 100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
        public void getElem_getElemFromArray_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.set(0,3);
        array.set(1,4);

        assertEquals(4,array.get(1).intValue());

    }
    @Test
    public void resize_resizeWithPositiveNumber_ResizeIsOk(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.resize(3);


        assertEquals(3,array.getSize());
    }
    @Test
    public void resize_resizeWithNumberLessThanSize_SizeIsTheSame(){
        DynamicArray<Integer> array = new DynamicArray<>(4);
        array.resize(2);


        assertEquals(4,array.getSize());
    }
    @Test
    public void get_getElemWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(2);

        array.set(0, 10);
        array.set(1, 20);
        try {
            array.get(2);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void insert_insertElemWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        try {
            array.insert(2, 10);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void insert_insertElemToThePosition_ArrayIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 400);

        array.insert(2, 300);

        assertEquals(300, array.get(2).intValue());
        assertEquals(400, array.get(3).intValue());
    }
    @Test
    public void pushBack_pushBackElem_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.set(0, 10);
        array.set(1, 20);


        array.pushBack(3);

        assertEquals(3, array.get(2).intValue());
    }
    @Test
    public void popBack_popBackElemFromEmptyArray_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }
    @Test
    public void remove_removeElemWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(2);
        try {
            array.remove(2);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }


    @Test
    public void getNext_getDataOfNextElem_ElemIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> elem1 = list.pushFront(1);
        Node<Integer> elem3 = list.pushFront(2);
        Node<Integer> elem = new Node<Integer>(3, elem3, elem1);

        Node<Integer> next = (Node<Integer>) elem.getNext();
        Node<Integer> prev = (Node<Integer>) elem.getPrev();

        assertEquals(2,next.getData().intValue());
        assertEquals(1, prev.getData().intValue());
       }


    @Test
    public void isEmpty_checkListWithElements_isEmptyFalse(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> elem = (Node<Integer>) list.pushBack(1);
        assertEquals(false, list.isEmpty());
    }
    @Test
    public void pushFront_pushElements_HeadIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);


        Node<Integer> head = (Node<Integer>) list.getHead();


        assertEquals(3, head.getData().intValue());

    }
    @Test
    public void pushFront_pushElements_TailIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);



        Node<Integer> tail = (Node<Integer>) list.getTail();


        assertEquals(1,tail.getData().intValue());
    }
    @Test
    public void get_getElemByIndexEqualsSize_ThrowsException(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(1);
        list.pushFront(2);
        try {
            list.get(2);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void pushBack_pushToEmptyList_sizeEqualsOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(20);
        assertEquals(1, list.getSize());
    }
    @Test
    public void pushFront_pushThreeElements_HeadIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(2);
        list.pushFront(1);
        list.pushFront(3);

        Node<Integer> head = (Node<Integer>) list.getHead();


        assertEquals(3,head.getData().intValue());

    }
    @Test
    public void pushFront_pushThreeElements_TailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(2);
        list.pushFront(1);
        list.pushFront(3);

        Node<Integer> tail = (Node<Integer>) list.getTail();


        assertEquals(2, tail.getData().intValue());
    }
    @Test
    public void remove_removeElementFromList_ConnectionBetweenNextAndPrevCorrect(){

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> elem = (Node<Integer>) list.pushBack(20);
        Node<Integer> next = (Node<Integer>) list.insertAfter(elem, 30);
        Node<Integer> prev = (Node<Integer>) list.insertBefore(elem, 10);

        list.remove(elem);

        Node<Integer> elem1 = (Node<Integer>) prev.getNext();
        Node<Integer> elem2 = (Node<Integer>) next.getPrev();

        assertEquals(30, elem1.getData().intValue());
        assertEquals(10, elem2.getData().intValue());
    }
    @Test
    public void insertListAfter_insertListAfterSecondElement_SequenceOfElementsIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushBack(10);
        Node<Integer> elem = (Node<Integer>) list1.pushBack(20);
        list1.pushBack(30);
        list1.pushBack(40);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);

        list1.insertListAfter(list1.get(1), list2);

        Node<Integer> zero = (Node<Integer>) list1.get(0);
        Node<Integer> one = (Node<Integer>) list1.get(1);
        Node<Integer> two = (Node<Integer>) list1.get(2);
        Node<Integer> three = (Node<Integer>) list1.get(3);
        Node<Integer> four = (Node<Integer>) list1.get(4);
        Node<Integer> five = (Node<Integer>) list1.get(5);

        assertEquals(10, zero.getData().intValue());
        assertEquals(20, one.getData().intValue());
        assertEquals(50, two.getData().intValue());
        assertEquals(60, three.getData().intValue());
        assertEquals(30, four.getData().intValue());
        assertEquals(40, five.getData().intValue());
    }
    @Test
    public void insertListBefore_insertListBeforeSecondElem_SequenceOfElementsIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(10);
        list1.pushBack(20);
        list1.pushBack(30);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);

        list1.insertListBefore(list1.get(1), list2);

        Node<Integer> zero = (Node<Integer>) list1.get(0);
        Node<Integer> one = (Node<Integer>) list1.get(1);
        Node<Integer> two = (Node<Integer>) list1.get(2);
        Node<Integer> three = (Node<Integer>) list1.get(3);
        Node<Integer> four = (Node<Integer>) list1.get(4);

        assertEquals(10, zero.getData().intValue());
        assertEquals(50, one.getData().intValue());
        assertEquals(60, two.getData().intValue());
        assertEquals(20, three.getData().intValue());
        assertEquals(30, four.getData().intValue());

    }
}
