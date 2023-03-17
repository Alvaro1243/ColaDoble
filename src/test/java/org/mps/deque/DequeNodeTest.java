package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

/**
 * @Author Miguel Jurado Vázquez
 */

/**
 * TESTS DESCRIPTION
 * Given a dequeNode with an item, a previous DequeNode and next DequeNode
 *  - when calling getItem method, then return the item => testGetItemReturnsExpectedItem()
 *  - when calling getPrevious method, then return the previous node => testGetPreviousReturnsExpectedNode()
 *  - when calling getNext method, then return the next node => testGetNextReturnsExpectedNode()
 *  - when calling setItem method, then set the item => testSetItem()
 *  - when calling setPrevious method, then set the previous node => testSetPrevious()
 *  - when calling setNext method, then set the next node => testSetNext()
 *  - when calling isFirstNode method, then return true => testIsFirstNodeTrue()
 *  - when calling isFirstNode method, then return false => testIsFirstNodeFalse()
 *  - when calling isLastNode, then return false => testIsLastNodeFalse()
 *  - when calling isNotATerminalNode method, then return true => testIsNotATerminalNodeTrue()
 *
 * Given a dequeNode with just an item (no previous DequeNode and no next DequeNode)
 *  - when calling getPrevious method, then return null => testGetPreviousReturnsNull()
 *  - when calling getNext method, then return null => testGetNextReturnsNull()
 *  - when calling isFirstNode method, then return true => testIsFirstNodeTrue()
 *  - when calling isLastNode method, then return true => testIsLastNodeTrue()
 *  - when calling isNotATerminalNode method, then return false => testIsNotATerminalNodeFalse()
 *
 * Given a dequeNode with an item and previous DequeNode (no next DequeNode)
 *  - when calling isNotATerminalNode method, then return false => testIsNotATerminalNodeFalse
 *
 * Given a dequeNode with an item and next DequeNode (no previous DequeNode)
 *  - when calling isNotATerminalNode method, then return false => testIsNotATerminalNodeFalse
 */

@DisplayName("A DequeNode")
class DequeNodeTest<T>{

    @Nested
    @DisplayName("with item, previous, and next")
    class DequeNodeWithItemPreviousNext{
        T item;
        DequeNode<T> previous;
        DequeNode<T> next;
        DequeNode<T> dequeNode;

        @BeforeEach
        void setUp() {
            item = (T) "Item";
            previous = new DequeNode<T>((T) "Previous", null, null);
            next = new DequeNode<T>((T) "Next", null, null);
            dequeNode = new DequeNode<T>(item, previous, next);
        }

        @Test
        @DisplayName("when calling getItem method, then return the item")
        void testGetItemReturnsExpectedItem() {
            assertEquals(item, dequeNode.getItem());
        }

        @Test
        @DisplayName("when calling getPrevious method, then return the previous node")
        void testGetPreviousReturnsExpectedNode() {
            assertEquals(previous, dequeNode.getPrevious());
        }

        @Test
        @DisplayName("when calling getNext method, then return the next node")
        void testGetNextReturnsExpectedNode() {
            assertEquals(next, dequeNode.getNext());
        }

        @Test
        @DisplayName("when calling setItem method, then set the item")
        void testSetItem() {
            T newItem = (T) "New Item";
            dequeNode.setItem(newItem);
            assertEquals(newItem, dequeNode.getItem());
        }

        @Test
        @DisplayName("when calling setPrevious method, then set the previous node")
        void testSetPrevious() {
            DequeNode<T> newPrevious = new DequeNode<T>((T) "New Previous", null, null);
            dequeNode.setPrevious(newPrevious);
            assertEquals(newPrevious, dequeNode.getPrevious());
        }

        @Test
        @DisplayName("when calling setNext method, then set the next node")
        void testSetNext() {
            DequeNode<T> newNext = new DequeNode<T>((T) "New Next", null, null);
            dequeNode.setNext(newNext);
            assertEquals(newNext, dequeNode.getNext());
        }

        @Test
        @DisplayName("when calling isFirstNode method, then return true")
        void testIsFirstNodeTrue() {
            previous = null;
            dequeNode = new DequeNode<T>(item, previous, next);
            assertTrue(dequeNode.isFirstNode());
        }

        @Test
        @DisplayName("when calling isFirstNode method, then return false")
        void testIsFirstNodeFalse() {
            assertFalse(dequeNode.isFirstNode());
        }

        @Test
        @DisplayName("when calling isLastNode, then return false")
        void testIsLastNodeFalse() {
            assertFalse(dequeNode.isLastNode());
        }

        @Test
        @DisplayName("when calling isNotATerminalNode method, then return true")
        void testIsNotATerminalNodeTrue(){
            assertTrue(dequeNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("with only a item (no previous DequeNode and no next DequeNode)")
    class DequeNodeWithOnlyAItem<T>{
        T item;
        DequeNode<T> dequeNode;

        @BeforeEach
        void setUp() {
            item = (T) "Item";
            dequeNode = new DequeNode<T>(item, null, null);
        }


        @Test
        @DisplayName("when calling getPrevious method, then return null")
        void testGetPreviousReturnsNull() {
            assertNull(dequeNode.getPrevious());
        }

        @Test
        @DisplayName("when calling getNext method, then return null")
        void testGetNextReturnsNull() {
            assertNull(dequeNode.getNext());
        }

        @Test
        @DisplayName("when calling isFirstNode method, then return true")
        void testIsFirstNodeTrue() {
            assertTrue(dequeNode.isFirstNode());
        }

        @Test
        @DisplayName("when calling isLastNode method, then return true")
        void testIsLastNodeTrue() {
            assertTrue(dequeNode.isLastNode());
        }

        @Test
        @DisplayName("when calling isNotATerminalNode method, then return false")
        void testIsNotATerminalNodeFalse(){
            assertFalse(dequeNode.isNotATerminalNode());
        }

    }

    @Nested
    @DisplayName("with item, previous DequeNode and no next DequeNode")
    class DequeNodeClassWithItemAndPrevious{
        T item;
        DequeNode<T> dequeNode;
        DequeNode<T> previous;

        @BeforeEach
        void setUp() {
            item = (T) "Item";
            previous = new DequeNode<T>((T) "Previous", null, null);
            dequeNode = new DequeNode<T>(item, previous, null);
        }

        @Test
        @DisplayName("when calling isNotATerminalNode method, then return false")
        void testIsNotATerminalNodeFalse(){
            assertFalse(dequeNode.isNotATerminalNode());
        }
    }

    @Nested
    @DisplayName("with item, next DequeNode and no previous DequeNode")
    class DequeNodeClassWithItemAndNext {
        T item;
        DequeNode<T> dequeNode;
        DequeNode<T> next;

        @BeforeEach
        void setUp() {
            item = (T) "Item";
            next = new DequeNode<T>((T) "Next", null, null);
            dequeNode = new DequeNode<T>(item, null, next);
        }

        @Test
        @DisplayName("when calling isNotATerminalNode method, then return false")
        void testIsNotATerminalNodeFalse(){
            assertFalse(dequeNode.isNotATerminalNode());
        }
    }
}