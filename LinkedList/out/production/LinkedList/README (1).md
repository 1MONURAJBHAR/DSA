# Arrays vs Linked Lists

A comprehensive comparison of two fundamental data structures in computer science.

---

## Overview

| Feature | Array | Linked List |
|---|---|---|
| Memory Layout | Contiguous | Non-contiguous (scattered) |
| Size | Fixed (static) or dynamic | Dynamic |
| Access Type | Random (index-based) | Sequential |
| Memory per element | Just the data | Data + pointer(s) |

---

## Memory Allocation

**Array**
- Elements are stored in contiguous memory locations.
- Memory is allocated at the time of declaration (static) or in a single block (dynamic).
- No extra memory overhead per element.

**Linked List**
- Nodes are scattered across memory; each node holds data and a pointer to the next node.
- Memory is allocated dynamically for each node.
- Extra memory required for storing pointers (8 bytes per pointer on 64-bit systems).

---

## Time Complexity

| Operation | Array | Linked List |
|---|---|---|
| Access (by index) | O(1) | O(n) |
| Search | O(n) | O(n) |
| Insertion at beginning | O(n) | O(1) |
| Insertion at end | O(1) amortized | O(n) or O(1) with tail pointer |
| Insertion at middle | O(n) | O(n) to find + O(1) to insert |
| Deletion at beginning | O(n) | O(1) |
| Deletion at end | O(1) | O(n) |
| Deletion at middle | O(n) | O(n) to find + O(1) to delete |

---

## Key Differences

### 1. Access Speed
- **Arrays** support **O(1) random access** — you can jump directly to any index using arithmetic on the base address.
- **Linked Lists** require **O(n) sequential traversal** — you must follow pointers from the head to reach a given node.

### 2. Insertion & Deletion
- **Arrays** require shifting elements when inserting or deleting in the middle — **O(n)** cost.
- **Linked Lists** only need pointer updates — **O(1)** once you're at the right node; no shifting needed.

### 3. Memory Usage
- **Arrays** are memory-efficient — only the data is stored.
- **Linked Lists** carry overhead for pointers — a singly linked list has 1 pointer per node; doubly linked has 2.

### 4. Cache Performance
- **Arrays** benefit from **cache locality** — contiguous memory means fewer cache misses.
- **Linked Lists** cause more **cache misses** — nodes are scattered in memory, causing frequent cache invalidation.

### 5. Size Flexibility
- **Arrays** have a fixed size (unless resized, which copies the entire array).
- **Linked Lists** grow and shrink dynamically without reallocation.

### 6. Reverse Traversal
- **Arrays** can be traversed in both directions trivially.
- **Singly Linked Lists** cannot be reversed without extra work; **Doubly Linked Lists** support bidirectional traversal.

---

## Types of Linked Lists

| Type | Description |
|---|---|
| Singly Linked List | Each node has one pointer → to the next node |
| Doubly Linked List | Each node has two pointers → next and previous |
| Circular Linked List | Last node points back to the first node |

---

## When to Use What

### Use an Array when:
- You need **fast random access** by index.
- The **size is known** in advance and doesn't change often.
- You want **better cache performance** (e.g., numerical computations, sorting).
- Memory overhead should be minimal.

### Use a Linked List when:
- You need **frequent insertions/deletions** at the beginning or middle.
- The **size is unknown** or changes frequently.
- You want to **avoid the cost of resizing** a dynamic array.
- Implementing stacks, queues, or graphs with adjacency lists.

---

## Advantages & Disadvantages

### Arrays

| ✅ Advantages | ❌ Disadvantages |
|---|---|
| O(1) random access by index | Fixed size (static arrays cannot grow) |
| Excellent cache locality — contiguous memory | Insertion/deletion at middle is O(n) due to shifting |
| Simple to implement and use | Resizing (dynamic arrays) copies the entire array — expensive |
| Less memory overhead (no pointers) | Wasted memory if array is pre-allocated but not fully used |
| Supports binary search (on sorted data) | Not suitable for frequent structural changes |
| Works well with CPU prefetching | Insertion at beginning always O(n) |

---

### Linked Lists

| ✅ Advantages | ❌ Disadvantages |
|---|---|
| Dynamic size — grows/shrinks at runtime | No O(1) random access; must traverse from head |
| O(1) insertion/deletion at head | Extra memory per node for pointer(s) |
| No memory wastage from pre-allocation | Poor cache performance due to scattered memory |
| Efficient for frequent insertions at beginning | Not compatible with binary search |
| Easy to implement stacks and queues | Reverse traversal requires a doubly linked list |
| No need to shift elements on insert/delete | More complex implementation than arrays |

---

## Code Examples

### Array (Python)
```python
# Declaration
arr = [10, 20, 30, 40, 50]

# Access - O(1)
print(arr[2])  # 30

# Insert at end - O(1) amortized
arr.append(60)

# Insert at beginning - O(n) due to shifting
arr.insert(0, 5)
```

### Linked List (Python)
```python
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):  # O(1)
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def traverse(self):  # O(n)
        curr = self.head
        while curr:
            print(curr.data, end=" -> ")
            curr = curr.next
        print("None")

ll = LinkedList()
ll.insert_at_beginning(30)
ll.insert_at_beginning(20)
ll.insert_at_beginning(10)
ll.traverse()  # 10 -> 20 -> 30 -> None
```

### Array (Java)
```java
import java.util.ArrayList;

public class ArrayExample {
    public static void main(String[] args) {

        // Static Array
        int[] staticArr = {10, 20, 30, 40, 50};

        // Access - O(1)
        System.out.println("Element at index 2: " + staticArr[2]); // 30

        // Iterate
        System.out.print("Static Array: ");
        for (int val : staticArr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Dynamic Array using ArrayList
        ArrayList<Integer> dynArr = new ArrayList<>();
        dynArr.add(10);       // Insert at end - O(1) amortized
        dynArr.add(20);
        dynArr.add(30);
        dynArr.add(0, 5);     // Insert at beginning - O(n) due to shifting
        dynArr.remove(Integer.valueOf(20)); // Delete by value - O(n)

        System.out.println("Dynamic Array: " + dynArr); // [5, 10, 30]

        // Search - O(n)
        System.out.println("Contains 30? " + dynArr.contains(30)); // true
    }
}
```

### Linked List (Java)
```java
public class LinkedListExample {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        // Insert at beginning - O(1)
        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Insert at end - O(n)
        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        // Delete by value - O(n)
        void delete(int data) {
            if (head == null) return;
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node curr = head;
            while (curr.next != null && curr.next.data != data) {
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }

        // Search - O(n)
        boolean search(int data) {
            Node curr = head;
            while (curr != null) {
                if (curr.data == data) return true;
                curr = curr.next;
            }
            return false;
        }

        // Traverse - O(n)
        void traverse() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtBeginning(30);
        ll.insertAtBeginning(20);
        ll.insertAtBeginning(10); // 10 -> 20 -> 30 -> null
        ll.insertAtEnd(40);       // 10 -> 20 -> 30 -> 40 -> null

        System.out.print("List: ");
        ll.traverse();

        ll.delete(20);
        System.out.print("After deleting 20: ");
        ll.traverse(); // 10 -> 30 -> 40 -> null

        System.out.println("Search 30: " + ll.search(30)); // true
        System.out.println("Search 99: " + ll.search(99)); // false
    }
}
```

---

## Summary

| Criteria | Winner |
|---|---|
| Random Access | ✅ Array |
| Insert/Delete at Head | ✅ Linked List |
| Memory Efficiency | ✅ Array |
| Dynamic Sizing | ✅ Linked List |
| Cache Performance | ✅ Array |
| Implementation Simplicity | ✅ Array |

> **Rule of thumb:** Prefer arrays for read-heavy workloads with known sizes. Prefer linked lists for write-heavy workloads with frequent structural changes.
