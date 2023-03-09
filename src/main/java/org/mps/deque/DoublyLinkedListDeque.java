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
        if(size==0){
            first = new DequeNode<>(value,null,last);
        }else if (size==1){
            DequeNode node = new DequeNode<>(value,null,first);
            first = node;
        }else{
            DequeNode node = new DequeNode<>(value,null,first);
            first = node;
        }
        size++;
    }

    @Override
    public void append(T value) {
        if(size==0){
            first = new DequeNode<>(value,null,last);
        }else if (size==1){
            last = new DequeNode<>(value,first,null);
            first.setNext(last);
        }else{
            DequeNode node = new DequeNode<>(value,last,null);
            last = node;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else {
            first = first.getNext();
        }
    }

    @Override
    public void deleteLast() {
        if(size==0){
            throw new DoubleEndedQueueException("The deque is empty");
        }else if(size==1){
            last = last.getPrevious();
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
        }else if(size==1){
            return first.getItem();
        }else {
            return last.getItem();
        }
    }

    @Override
    public int size() {
        DequeNode aux = first;
        int size = 0;
        while (aux!=null){
            size++;
            aux = aux.getNext();
        }
        return size;
    }
}
