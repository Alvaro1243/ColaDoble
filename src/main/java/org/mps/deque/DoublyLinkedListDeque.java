package org.mps.deque;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/*
@author Álvaro Bermúdez Gámez
 */
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

    // NEW OPERATIONS
    @Override
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        DequeNode<T> aux = first;
        int i = 0;
        boolean found = false;
        while(!found){
            if (i == index){
                found = true;
            } else {
                aux = aux.getNext();
            }
            i++;
        }
        return aux.getItem();
    }

    @Override
    public boolean contains(T value){
        DequeNode<T> aux = first;

        while(aux != null){
            if (Objects.equals(aux.getItem(), value)){
                return true;
            }
            aux = aux.getNext();
        }

        return false;
    }

    @Override
    public void remove(T value){
        DequeNode<T> current = first;
        DequeNode<T> previous = null;
        boolean found = false;

        if (contains(value)){
            while(current != null && !found){
                if (Objects.equals(current.getItem(),value)){
                    // Value found
                    found = true;
                    if (previous == null){
                        // It is the head of the list
                        first = current.getNext();
                    } else {
                        previous.setNext(current.getNext());
                        if (current.getNext() != null){
                            // Middle node
                            current.getNext().setPrevious(previous);
                        } else {
                            // Tail of the list
                            last = previous;
                        }
                    }

                    size--;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator){
        if (size == 0) {
            return;
        }

        // Crear un array temporal
        T[] array = (T[]) new Object[size];

        // Add elements of the listDeque to the array
        DequeNode<T> current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.getItem();
            current = current.getNext();
        }

        // Sort the array
        Arrays.sort(array, comparator);

        // Change the values between the array and the list
        current = first;
        index = 0;
        while (current != null) {
            current.setItem(array[index++]);
            current = current.getNext();
        }
    }
}
