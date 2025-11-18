package logics.collection.list;

import java.util.Iterator;
import java.util.Arrays;

    public class LinkedList {

    public static void main(String[] args) {

        java.util.LinkedList<String> list = new java.util.LinkedList<>();

        // 1. Simple add
        list.add("Burger");
        list.add("Pizza");
        list.add("Pasta");
        System.out.println("After add(): " + list);

        // 2. add at specific index
        list.add(1, "Sandwich");
        System.out.println("After add(index, element): " + list);

        // 3. addFirst & addLast
        list.addFirst("Fries");
        list.addLast("Coffee");
        System.out.println("After addFirst & addLast: " + list);

        // 4. offer(), offerFirst(), offerLast() - Queue style
        list.offer("Brownie");
        list.offerFirst("Soup");
        list.offerLast("IceCream");
        System.out.println("After offer*, offerFirst, offerLast: " + list);

        // 5. push() - Stack style
        list.push("Taco"); // same as addFirst()
        System.out.println("After push(): " + list);

        // 6. addAll()
        list.addAll(Arrays.asList("Dosa", "Idli"));
        System.out.println("After addAll(Collection): " + list);

        // 7. addAll(index, Collection)
        list.addAll(3, Arrays.asList("Poha", "Upma"));
        System.out.println("After addAll(index, Collection): " + list);

        // 8. Update element
        list.set(2, "Noodles");
        System.out.println("After set(): " + list);

        // 9. Remove element
        list.remove("Coffee");
        System.out.println("After remove(value): " + list);

        // 10. Iterator
        System.out.print("Iterator Traversal: ");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // 11. Peek / Poll
        System.out.println("Peek: " + list.peek());
        System.out.println("Poll: " + list.poll());
        System.out.println("After poll: " + list);

        // 12. Clear
        list.clear();
        System.out.println("After clear(): " + list);
    }
}

