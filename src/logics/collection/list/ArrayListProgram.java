package logics.collection.list;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

    public class ArrayListProgram {
        public static void main(String[] args) {

            // Create ArrayList
            ArrayList<String> list = new ArrayList<>();

            // 1. Add elements
            list.add("Burger");
            list.add("Pizza");
            list.add("Pasta");
            list.add("Momos");

            

            System.out.println("Initial List: " + list);

            // 2. Add element at specific index
            list.add(1, "Sandwich");
            System.out.println("After adding at index 1: " + list);

            // 3. Update element
            list.set(2, "Noodles");
            System.out.println("After update at index 2: " + list);

            // 4. Remove element by index
            list.remove(3);
            System.out.println("After removing index 3: " + list);

            // 5. Remove by value
            list.remove("Momos");
            System.out.println("After removing 'Momos': " + list);

            // 6. Search element
            System.out.println("Contains Pizza? " + list.contains("Pizza"));

            // 7. Get element
            System.out.println("Item at index 1: " + list.get(1));

            // 8. Size of list
            System.out.println("Size: " + list.size());

            // 9. Iterate using Iterator (Universal Iterator)
            System.out.print("Iterator Traversal: ");
            Iterator<String> itr = list.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();

            // 10. Iterate using for-each loop
            System.out.print("For-each Traversal: ");
            for (String item : list) {
                System.out.print(item + " ");
            }
            System.out.println();

            // 11. Sort the list
            Collections.sort(list);
            System.out.println("Sorted List: " + list);

            // 12. Clear list
            list.clear();
            System.out.println("After clear(): " + list);
        }
    }

