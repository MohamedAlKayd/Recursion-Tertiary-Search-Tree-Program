// Mohamed Mahmoud
// Recursion Tertiary Search Tree Program - Tertiary Search Tree

// - Start of the Program -

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TST<T extends Comparable<T>> implements Iterable<T>{
    
    // root node of the tree
    TSTNode<T> root;

    // constructor
    public TST() {
        this.root = null;
    }

// - Insert function -

    public void insert(T element){
        if (this.root == null){
            TSTNode<T> newnode = new TSTNode<> (element);
            this.root = newnode;
        }
        else{
        this.root.inserthelper(element);
    }
    }

// - Remove Function -

    public void remove(T element){
        if(root == null){
            return;
        }
        else{
            this.root = this.root.removehelper(element, this.root);
        }
    }

// - Contains Function -

    public boolean contains(T element){
        return this.root.containshelper(element);

    }

// - Rebalance Function -

    public void rebalance(){
        ArrayList inorderlist = inordertraversal(this.root, new ArrayList<T>());
        TST<T> newtree = new TST<>();
        this.root = function(newtree, inorderlist).root;
    }

// - Tertiary Search Tree Function -

   public TST function(TST rootname, ArrayList inorderlist){
        if (!(inorderlist.isEmpty())){
            List <T> inorder = inorderlist;
            int middle = ((inorderlist.size()/2));
            rootname.insert((T) inorder.get(middle));
            ArrayList <T> prototype1 = new ArrayList <T> ();
            for(int x=0; x<middle; x++){
                prototype1.add((T) inorderlist.get(x));
            }
            ArrayList <T> prototype2 = new ArrayList <T> ();
            for(int x=middle+1; x<inorderlist.size(); x++){
                prototype2.add((T) inorderlist.get(x));
            }
            function(rootname, prototype1);
            function(rootname, prototype2);
            return rootname;
            }
       return rootname;
   }

    /**
     * Caculate the height of the tree.
     *
     * @return -1 if the tree is empty otherwise the height of the root node
     */
    public int height(){
        if (this.root == null)
            return -1;
        return this.root.height();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        TSTIterator<T> iter = new TSTIterator<T>(this);
        return iter;
    }

// - In Order Traversal Function -

    public ArrayList<T> inordertraversal(TSTNode<T> root, ArrayList<T> listtest){
        if (root == null){
            return null;
        }else {
            inordertraversal(root.left, listtest);
            listtest.add(root.element);
            inordertraversal(root.mid, listtest);
            inordertraversal(root.right, listtest);
        }
        return listtest;
    }

    @Override
    public String toString() {
        if (this.root == null)
            return "empty tree";
        // creates a buffer of 100 characters for the string representation
        StringBuilder buffer = new StringBuilder(100);
        // build the string
        stringfy(buffer, this.root,"", "");
        return buffer.toString();
    }

    /**
     * Build a string representation of the tertiary tree.
     * @param buffer String buffer
     * @param node Root node
     * @param nodePrefix The string prefix to add before the node's data (connection line from the parent)
     * @param childrenPrefix The string prefix for the children nodes (connection line to the children)
     */
    private void stringfy(StringBuilder buffer, TSTNode<T> node, String nodePrefix, String childrenPrefix) {
        buffer.append(nodePrefix);
        buffer.append(node.element);
        buffer.append('\n');
        if (node.left != null)
            stringfy(buffer, node.left,childrenPrefix + "|~~ ", childrenPrefix + "|   ");
        else
            buffer.append(childrenPrefix + "|~~ null\n");
        if (node.mid != null)
            stringfy(buffer, node.mid,childrenPrefix + "|-- ", childrenPrefix + "|   ");
        else
            buffer.append(childrenPrefix + "|-- null\n");
        if (node.right != null)
            stringfy(buffer, node.right,childrenPrefix + "|__ ", childrenPrefix + "    ");
        else
            buffer.append(childrenPrefix + "|__ null\n");
    }

    /**
     * Print out the tree as a list using an enhanced for loop.
     * Since the Iterator performs an inorder traversal, the printed list will also be inorder.
     */
    public void inorderPrintAsList(){
        String buffer = "[";
        for (T element: this) {
            buffer += element + ", ";
        }
        int len = buffer.length();
        if (len > 1)
            buffer = buffer.substring(0,len-2);
        buffer += "]";
        System.out.println(buffer);
    }
}

// - End of the Program -
