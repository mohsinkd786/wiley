package com.mohsinkd786.dsalgo;

import java.util.PriorityQueue;

public class DsMainClass {
    public static void main(String[] args) {

        //
        Integer[] ints = new Integer[2];
        ints[0] = 1;

        ints[0] = 2;

        PriorityQueue queue = new PriorityQueue();


        // Linked List
        // Head -> [1,[ref to node 2]]
        //                      --> [2,[ref to node 3]]
        //                                    --> [3,[ref to node 1]/empty]--> null / nothing

        // Double ended list
        // Head -> [null,1,[ref to node 2]]
        //                      --> [[ref to 1],2,[ref to node 3]]
        //                                    --> [[ref to 2],3,[ref to node 1]/empty]--> null / nothing

        // Circular
        // Head -> [1,[ref to node 2]]
        //                      --> [2,[ref to node 3]]
        //                                    --> [3,[ref to node 1]]-->  / nothing


        // List


        // Insertion  - O(1)
        // Search + Insertion = O(n)
        //

        // 1
        // N
        // O()


        // Stack - Last In First Out

        // Push  - Add a new element , on top
        // Pop - delete an element ,from top
        // Peek - get the top most element


        // Queue - FIFO

        // Enqueue - add a new record - happens at the end / rear
        // deque - remove a record - remove at the head / beginning / front
        // peek - get the record / front


        // 1. Simple Queue - FIFO
        // 2. Circular Queue -
        // 3. Priority Queue -

        // REAR [1,1,6,7,9,-1] - FRONT

        // REAR - [(11,P9),(10,P6),(8,P7)]- FRONT





        // Array Based Implementation
        // Insertion - O(1)
        // Delete - O(1)

        // Performance Metrics
        /**
         *  Space Complexity
         *
         *
         *  Time Complexity
         *
         *
         *  Insertion - how much time does a linked list take to insert a new value
         *  Search - how much time does a DS take to search for a record
         *  Deletion - how much time does it need to identify & delete a record
         *  sort -
         *
         *
         *
         *
         *  Asymptotic Notations :
         *
         *  1. Big O -> worst case -
         *  2. Omega -> best case -
         *  3. Theta -> average case -
         *
         * */

    }
}

/**
 *  Data Structures
 *
 *  1. Linear
 *      a. Arrays :
 *      b. LinkedList:
 *      c. Stack
 *      d. Queue
 *  2. Hierarchical / Non- Linear
 *      a. Tree
 *      b. Graph
 *      c. Heap
 *
 *
 * */
