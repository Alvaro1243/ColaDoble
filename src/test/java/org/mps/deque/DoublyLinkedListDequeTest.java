package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
@author Álvaro Bermúdez Gámez
The nested ("when new") represents the test cases when a DoublyLinkedListDeque is empty
        - When tried to delete at any side throw exception
        - When tried to peek at any side throw exception
        - The structure is empty
The nested ("after inserting an element at the end") represents the test cases after inserting in an empty structure
an element at the end
        - The structure isn't empty
        - After deleting the first or the last is empty
        - The first element is the last element
        The nested ("and at the front") continue this cases after inserting at the front of the structure
                - When deleting isn't empty
                - The first element is different of the last
The nested ("after inserting an element at the front") represents the test cases after inserting in an empty structure
an element at the front
        - The structure isn't empty
        - After deleting the first or the last is empty
        - The first element is the last element
        The nested ("and at the end") continue this cases after inserting at the end of the structure
                - When deleting isn't empty
                - The first element is different of the last
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

        @Test
        @DisplayName("throws IndexOutOfBoundsException when getting index 0")
        void indexEmptyDeque(){
            assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedListDeque.get(0));
        }

        @Test
        @DisplayName("throws IndexOutOfBoundsException when requested index -1")
        void getInvalidNegativeIndex(){
            assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedListDeque.get(-1));
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

            @Test
            @DisplayName("throws IndexOutOfBoundsException when requested index 1")
            void getInvalidPositiveIndex(){
                assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedListDeque.get(1));
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
                    int actualValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,actualValue);
                }

                @Test
                @DisplayName("the first element has the index 0")
                void firstElementIndex0(){
                    int expectedValue = doublyLinkedListDeque.first();

                    int index = 0;
                    int actualValue = doublyLinkedListDeque.get(index);

                    assertEquals(expectedValue,actualValue);
                }

                @Test
                @DisplayName("the last element has the index 1")
                void lastElementIndex1(){
                    int expectedValue = doublyLinkedListDeque.last();

                    int index = 1;
                    int actualValue = doublyLinkedListDeque.get(index);

                    assertEquals(expectedValue,actualValue);
                }
            }

        }

        @Nested
        @DisplayName("after inserting a element (2) at the end")
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

            @Test
            @DisplayName("contains the element 2")
            void containsElement(){
                boolean expectedValue = true;

                boolean actualValue = doublyLinkedListDeque.contains(2);

                assertEquals(expectedValue,actualValue);
            }

            @Test
            @DisplayName("not contains the element 3")
            void notContainsElement(){
                boolean expectedValue = false;

                boolean actualValue = doublyLinkedListDeque.contains(3);

                assertEquals(expectedValue,actualValue);
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
                @DisplayName("after deleting last isn't empty")
                void endDeleteFirst(){
                    int expectedValue = 1;

                    doublyLinkedListDeque.deleteFirst();
                    int obtainedValue = doublyLinkedListDeque.size();

                    assertEquals(expectedValue,obtainedValue);
                }

                @Test
                @DisplayName("the first element is different from the last")
                void FirstNotSameLast(){
                    int expectedValue = doublyLinkedListDeque.first();

                    int obtainedValue = doublyLinkedListDeque.last();

                    assertNotEquals(expectedValue,obtainedValue);
                }
            }
        }
    }

}