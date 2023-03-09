package org.mps.deque;

//import static javax.swing.text.rtf.RTFAttributes.BooleanAttribute.True;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;


class DequeNodeTest {
    DequeNode<Integer> node1 = new DequeNode<Integer>(1, null, null);
    DequeNode<Integer> node2 = new DequeNode<Integer>(2, null, null);
    DequeNode<Integer> node3 = new DequeNode<Integer>(3, null, null);

    @BeforeEach
    void setUp(){
        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);
    }

    @AfterEach
    void tearDown(){
        node1.setPrevious(null);
        node1.setNext(null);
        node2.setPrevious(null);
        node2.setNext(null);
        node3.setPrevious(null);
        node3.setNext(null);
    }

    @Nested
    @DisplayName("Test cases for getters methods")
    class TestsCasesForGettersMethods{

        @Test
        void getItemMethodReturnsExpectedValue(){
            assertEquals(1, node1.getItem());
        }

        @Test
        void getPreviousMethodReturnsExpectedValue(){
            assertSame(node1, node2.getPrevious());
        }

        @Test
        void getPreviousMethodReturnsNullForFirstNode(){
            assertNull(node1.getPrevious());
        }

        @Test
        void getNextMethodReturnsNullForLastNode(){
            assertNull(node3.getNext());
        }

        @Test
        void getNextMethodReturnsExpectedValue(){
            assertSame(node3, node2.getNext());
        }

        @Test
        void getItemMethodReturnsNullForEmptyNode() {
            DequeNode<Integer> emptyNode = new DequeNode<>(null, null, null);
            assertNull(emptyNode.getItem());
        }
    }


    @Nested
    @DisplayName("Tests cases for setters methods")
    class TestsCasesForSettersMethods{

        @Test
        void setItemMethod(){
            node1.setItem(5);

            assertEquals(5, node1.getItem());
        }

        @Test
        void setPreviousMethod(){
            DequeNode<Integer> node0 = new DequeNode<Integer>(0, null, null);

            node1.setPrevious(node0);

            assertSame(node0, node1.getPrevious());
        }

        @Test
        void setNextMethod(){
            DequeNode<Integer> node4 = new DequeNode<Integer>(4, null, null);

            node3.setNext(node4);

            assertSame(node4, node3.getNext());
        }
    }


    @Nested
    @DisplayName("Test cases for boolean methods")
    class TestCasesForBooleanMethods{

        @Test
        void isFirstNodeMethodReturnsExpectedValue(){
            assertFalse(node2.isFirstNode());
        }

        @Test
        void isLastNodeMethodReturnsExpectedValue(){
            assertTrue(node3.isLastNode());
        }

        @Test
        void isNotATerminalNodeReturnsExpectedValue(){
            assertFalse(node3.isNotATerminalNode());
        }
    }
}