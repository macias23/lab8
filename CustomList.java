

public class CustomList {
    private Node root;
    private int size;

    public CustomList() {
        root = null;
        size = 0;
    }

    /**
     * Adds the new node to the list
     *
     * @param value added to the list
     */
    public void add(int value) {
        Node node = root;
        Node newNode = new Node(value);
        // we have the empty list, so add the new node as the root
        if (root == null) {
            root = newNode;
        } else {
            // traverse through the list to find the last node
            while (node.getNext() != null) {
                node = node.getNext();
            }
            // add the new node after the last one
            node.setNext(new Node(value));
        }
        // increase the size of the list
        ++size;
    }

    /**
     * Removes all items from the list with a given value
     *
     * @param value - value present in nodes
     * @return number of removed elements
     */
    public int remove(int value) {
        Node node = root;
        boolean changed = false;
        int changes = 0;
        //traverse through the list to find nodes with given value
        while (node != null) {
            if (node.getValue() == value) {
                changed = true;
                //case when there is only one element in the list
                if (size == 1) {
                    root = null;
                    size--;
                    changes++;
                    break;
                }
                //deleting the element
                node.setValue(node.getNext().getValue());
                //one element before the last one is being deleted case
                if (node.getNext().getNext()== null&&node.getNext().getValue()==node.getValue()){
                    node.setNext(null);
                    size--;
                    break;
                }
                //setting next element for the one using for replacement
                if (node.getNext().getNext() != null)
                    node.setNext(node.getNext().getNext());
                size--;
                changes++;
            }
                //setting next to be checked
                if (node.getNext() != null) {
                    //for last element
                        if(node.getNext().getNext()==null&& node.getNext().getValue() == value) {
                        node.setNext(null);
                        size--;
                        changes++;
                        break;
                    }
                    node = node.getNext();
                } else if (changed)
                    return changes;
                else return -1;
        }
        return -1;
    }
    public int remove(int[]values){
        int changes=0;
        for (int value: values) {
            changes+=remove(value);
        }
        return changes;
    }


        /**
         * Removes the head from the list.
         * @return true if the operations was done correctly, false otherwise
         */
        public boolean pop () {
            //for empty list
            if (size == 0) return false;
            //for one element list
            if (root.getNext() == null) {
                root = null;
                size--;
            }
            //normal case
            else {
                root = root.getNext();
                size--;
            }
            return false;
        }

        /**
         * Returns the size of the list
         * @return the integer saying, how many elements the list contains
         */
        public int length () {
            return size;
        }

        /**
         * Finds a node in the list with the given value
         * @param value what value should be found
         * @return first node with a given value or null if none is present in the list
         */
        public Node getNode ( int value){
            Node result = root;
            while (result != null) {
                if (result.getValue() == value) {
                    return result;
                }
                result = result.getNext();
            }
            return null;
        }

        public Node getRoot () {
            return root;
        }


        @Override
        public String toString () {
            StringBuilder s = new StringBuilder();
            Node node = root;
            while (node != null) {
                s.append(node.getValue());
                s.append(" ");
                node = node.getNext();
            }
            return s.toString();
        }

    public static void main (String[]args){
            CustomList customList = new CustomList();
            customList.add(5);
            customList.add(7);
            customList.add(9);
            customList.add(1);
            customList.add(5);
            customList.add(9);
            customList.add(7);
            customList.add(3);

            System.out.println("Prime list: " + customList + " Size: " + customList.length());
            System.out.println("My tests");
            customList.remove(1);
            System.out.println("Removing 1 (existing element)");
            System.out.println("List: " + customList + " Size: " + customList.length());
            customList.remove(10);
            System.out.println("Removing 10 (not existing element)");
            System.out.println("List: " + customList + " Size: " + customList.length());
            customList.add(1);
            System.out.println("Adding 1 after removing");
            System.out.println("List: " + customList + " Size: " + customList.length());
            customList.pop();
            System.out.println("Removing root");
            System.out.println("List: " + customList + " Size: " + customList.length());
            System.out.println("Removing multiple elements (9 value)");
            customList.remove(9);
            System.out.println("List: " + customList + " Size: " + customList.length());
            int[] toRemove={1,7};
            System.out.println("Removing 7 and 1 at once");
            customList.remove(toRemove);
            System.out.println("List: " + customList + " Size: " + customList.length());


        // TODO: Write tests in here
            //  Including: removing existing element, removing non-existing element,
            //  add after remove, removing root, removing multiple elements
        }
    }
