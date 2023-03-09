package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A DoublyLinkedListDeque")
class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque doublyLinkedListDeque;

    @Nested
    @DisplayName("when new")
    class WhenNew{

        @BeforeEach
        void create(){
            doublyLinkedListDeque = new DoublyLinkedListDeque();
        }
        @Test
        @DisplayName("is empty")
        void isEmpty(){
            int expectedValue = 0;

            int obtainedValue = doublyLinkedListDeque.size();

            assertEquals(expectedValue,obtainedValue);
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when requested first element")
        void firstEmpty(){
            assertThrows(DoubleEndedQueueException.class,()->doublyLinkedListDeque.first());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when requested last element")
        void lastEmpty(){
            assertThrows(DoubleEndedQueueException.class,()->doublyLinkedListDeque.last());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when delete first element")
        void deleteFirstEmpty(){
            assertThrows(DoubleEndedQueueException.class,()->doublyLinkedListDeque.deleteFirst());
        }

        @Test
        @DisplayName("throws DoubleEndedQueueException when delete last element")
        void deleteLastEmpty(){
            assertThrows(DoubleEndedQueueException.class,()->doublyLinkedListDeque.deleteLast());
        }

        @Nested
        @DisplayName("after inserting a element")
        class AfterInserting{

        }
    }

}