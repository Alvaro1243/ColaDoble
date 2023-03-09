package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
@author Álvaro Bermúdez Gámez
 */
@DisplayName("A DoublyLinkedListDeque")
class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> doublyLinkedListDeque;

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
        @DisplayName("after inserting a element at the front")
        class AfterInsertingFront{

            @BeforeEach
            void insertFront(){
                doublyLinkedListDeque.prepend(1);
            }
            @Test
            @DisplayName("isn't empty")
            void frontEmpty(){
                int expectedValue = 1;

                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("after deleting first is empty")
            void frontDeleteFirst(){
                int expectedValue = 0;

                doublyLinkedListDeque.deleteFirst();
                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("after deleting last is empty")
            void frontDeleteLast(){
                int expectedValue = 0;

                doublyLinkedListDeque.deleteLast();
                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("the first element is the last")
            void firstSameLast(){
                int expectedValue = doublyLinkedListDeque.first();

                int obtainedValue = doublyLinkedListDeque.last();

                assertEquals(expectedValue,obtainedValue);
            }

            @Nested
            @DisplayName("and at the end")
            class AfterInsertingEnd{
                @BeforeEach
                void insertEnd(){
                    doublyLinkedListDeque.append(2);
                }

                @Test
                @DisplayName("the first element is different from the last")
                void firstNotSameLast(){
                    int expectedValue = doublyLinkedListDeque.first();

                    int obtainedValue = doublyLinkedListDeque.last();

                    assertNotEquals(expectedValue,obtainedValue);
                }

                @Test
                @DisplayName("after deleting first isn't empty")
                void endDeleteFirst(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteFirst();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }

                @Test
                @DisplayName("after deleting last isn't empty")
                void endDeleteLast(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteLast();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }
            }

        }

        @Nested
        @DisplayName("after inserting a element at the end")
        class AfterInsertingFirstEnd{

            @BeforeEach
            void insertEnd(){
                doublyLinkedListDeque.append(2);
            }

            @Test
            @DisplayName("the first element is the last")
            void firstSameLast(){
                int expectedValue = doublyLinkedListDeque.first();

                int obtainedValue = doublyLinkedListDeque.last();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("isn't empty")
            void endEmpty(){
                int expectedValue = 1;

                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("after deleting first is empty")
            void endDeleteFirst(){
                int expectedValue = 0;

                doublyLinkedListDeque.deleteFirst();
                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Test
            @DisplayName("after deleting last is empty")
            void endDeleteLast(){
                int expectedValue = 0;

                doublyLinkedListDeque.deleteLast();
                int obtainedValue = doublyLinkedListDeque.size();

                assertEquals(expectedValue,obtainedValue);
            }

            @Nested
            @DisplayName("and at the front")
            class AfterInsertingFront{
                @BeforeEach
                void insertFront(){
                    doublyLinkedListDeque.prepend(1);
                }

                @Test
                @DisplayName("after deleting first isn't empty")
                void frontDeleteFirst(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteFirst();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }

                @Test
                @DisplayName("after deleting first isn't empty")
                void endDeleteFirst(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteFirst();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }

                @Test
                @DisplayName("after deleting last isn't empty")
                void endDeleteLast(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteLast();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }
            }
        }
    }

}