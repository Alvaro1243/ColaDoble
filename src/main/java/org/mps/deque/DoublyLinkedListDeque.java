package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode node = new DequeNode<>(value,null,null);
        if(size==0){
            first = node;
            last = node;
        }else{
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode node = new DequeNode<>(value,null,null);
        if(size==0){
            first = node;
            last = node;
        }else{
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else {
            DequeNode aux = first;
            first = first.getNext();

            if (first==null){
                last = null;
            }else {
                first.setPrevious(null);
            }
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else {
            DequeNode aux = last;
            last = last.getPrevious();

            if (last==null){
                first = null;
            }else {
                last.setNext(null);
            }
            size--;
        }
    }

    @Override
    public T first() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else {
            return first.getItem();
        }
    }

    @Override
    public T last() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else{
            return last.getItem();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
