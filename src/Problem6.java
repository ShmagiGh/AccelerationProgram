import java.math.BigInteger;

public class Problem6 {
    public static class MyLinkedList<T> {
        Node<T> root;

        public static class Node<T> {
            T value;
            Node<T> next;

            public void addNode(T element) {
                next = new Node<>();
                next.value = element;
            }
        }

        MyLinkedList() {}

        public void add(T element) {
            if(root == null) {
                root = new Node<>();
                root.value = element;
                return;
            }
            Node<T> currNode = root;
            while(currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.addNode(element);
        }
        public T get(T element) {
            Node<T> currNode = root;
            if(currNode == null) {
                return null;
            }
            while(currNode.value != element) {
                if(currNode.next == null) {
                    return null;
                }
                currNode = currNode.next;
            }
            return currNode.value;
        }

        public void remove(T element) {
            Node<T> prevNode = root;
            Node<T> currNode = root;
            while(currNode.value != element) {
                if(currNode.next == null) {
                    return;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            if(currNode == root) {
                root = new Node<>();
                return;
            }
            prevNode.next = currNode.next;

        }
    }
    public static class MyHashSet<T> {
        int bucket_count;
        MyLinkedList<T>[] buckets;

        MyHashSet(int nbucket) {
            bucket_count = nbucket;
            buckets = new MyLinkedList[nbucket];
            for(int i = 0; i < nbucket; i ++) {
                buckets[i] = new MyLinkedList<T>();
            }
        }

        public void add(T elem) {
            int bucket_idx = elem.hashCode() % bucket_count;
            buckets[bucket_idx].add(elem);
        }
        public void remove(T elem) {
            int bucket_idx = elem.hashCode() % bucket_count;
            buckets[bucket_idx].remove(elem);
        }
        public T get(T elem) {
            int bucket_idx = elem.hashCode() % bucket_count;
            return buckets[bucket_idx].get(elem);
        }
    }

    /*
        We can compensate memory to speed up deletion process. If we increase amount of buckets, hash codes will be
        more spread out among them, meaning that elements will be placed on individual lists
        and, so, reaching one we want will be fast.
     */
    public static void main(String[] args) {
//        testLinkedList();
        testHashSet();
    }

    public static void testLinkedList() {
        MyLinkedList<Integer> l = new MyLinkedList<>();
        l.add(3);
        l.add(5);
        l.add(4);
        l.add(7);

        System.out.println(l.get(2));
        System.out.println(l.get(4));
        l.remove(4);
        l.remove(5);
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println(l.get(5));
        System.out.println(l.get(7));
    }

    public static void testHashSet() {
        MyHashSet<Integer> s = new MyHashSet<>(10);
        s.add(3);
        s.add(5);
        s.add(4);
        s.add(7);

        System.out.println(s.get(2));
        System.out.println(s.get(4));
        s.remove(4);
        s.remove(5);
        System.out.println(s.get(3));
        System.out.println(s.get(4));
        System.out.println(s.get(5));
        System.out.println(s.get(7));
    }

}
