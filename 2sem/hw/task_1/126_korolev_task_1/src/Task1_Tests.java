import org.junit.Assert;
import org.junit.Test;

public class Task1_Tests extends Assert {
    @Test
    public void getSize_getSizeOfEmptyArray_SizeEqualsZero(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }
    @Test
    public void getSize_getSizeOfArrayWithDefaultSize_SizeEqualsDefaultSize(){
        DynamicArray<Integer> array = new DynamicArray<>(DynamicArray.DefaultSize);
        assertEquals(1024, array.getSize());
    }
    @Test
    public void get_getElementFromArray_ElementIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(2);

        array.set(0, 10);
        array.set(1, 20);

        assertEquals(20, array.get(1).intValue());
        assertEquals(10, array.get(0).intValue());
    }
    @Test
    public void get_getElementOutOfBounds_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(3);

        array.set(0, 10);
        array.set(1, 20);
        array.set(2, 30);
        try {
            array.get(100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void resize_setNewSizeWithPositiveValue_NewSizeIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(1);
        array.resize(5);
        assertEquals(5, array.getSize());
    }
    @Test
    public void resize_setNewSizeLessThanSize_SizeDoesNotChange(){
        DynamicArray<Integer> array = new DynamicArray<>(4);
        array.resize(2);
        assertEquals(4, array.getSize());
    }
    @Test
    public void get_getElementWithIndexEqualsSize_ThrowsException(){
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
    public void set_setElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.set(3, 100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void insert_insertElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.insert(3, 100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
    @Test
    public void insert_insertElementToTheSecondPosition_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 400);

        array.insert(2, 300);

        assertEquals(300, array.get(2).intValue());
        assertEquals(400, array.get(3).intValue());
    }
    @Test
    public void pushBack_pushBackElement_ElemIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 300);

        array.pushBack(400);

        assertEquals(400, array.get(3).intValue());
    }
    @Test
    public void popBack_popBackElementFromEmptyArray_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }
    @Test
    public void remove_removeElementWithIndexEqualsSize_ThrowsException(){
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.remove(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void isEmpty_checkListWithoutElements_isEmptyTrue(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(true, list.isEmpty());
    }
    @Test
    public void isEmpty_checkListWithElements_isEmptyFalse(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> elem = (Node<Integer>) list.pushBack(1);
        assertEquals(false, list.isEmpty());
    }
    @Test
    public void pushFront_pushElements_HeadAndTailIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(20);
        list.pushFront(10);
        list.pushFront(30);


        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();

        assertEquals(30, head.getData().intValue());
        assertEquals(20, tail.getData().intValue());
    }
    @Test
    public void get_getElementByIndex_GetCorrectElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(20);
        list.pushBack(10);
        Node<Integer> elem = (Node<Integer>) list.get(1);
        assertEquals(10, elem.getData().intValue());
    }
    @Test
    public void pushBack_pushToEmptyList_sizeEqualsOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(20);
        assertEquals(1, list.getSize());
    }
    @Test
    public void pushFront_pushThreeElements_HeadAndTailIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(20);
        list.pushFront(10);
        list.pushFront(30);

        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();

        assertEquals(30, head.getData().intValue());
        assertEquals(20, tail.getData().intValue());
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
    @Test
    public void getNext_getDataOfNextElem_ElemIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        Node<Integer> elem1 = list.pushFront(10);
        Node<Integer> elem3 = list.pushFront(30);
        Node<Integer> elem = new Node<Integer>(20, elem3, elem1);

        Node<Integer> next = (Node<Integer>) elem.getNext();
        Node<Integer> prev = (Node<Integer>) elem.getPrev();

        assertEquals(30, next.getData().intValue());
        assertEquals(10, prev.getData().intValue());
    }
}
