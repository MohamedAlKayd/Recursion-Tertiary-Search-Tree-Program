// Mohamed Mahmoud
// Recursion Tertiary Search Tree Program - Tertiary Search Tree Iterator -

// - Start of the Program -

import java.util.ArrayList;
import java.util.Iterator;

class TSTIterator<T extends Comparable<T>> implements Iterator<T> {

    ArrayList<T> list;
    int a = 0;

    public TSTIterator(TST<T> tree) {
        ArrayList<T> listtest = new ArrayList<T>();
        this.list = tree.inordertraversal(tree.root, listtest);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next}
     * would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        //Iterator i = list.iterator();
        if (a < list.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
    */
    @Override
    public T next() {
        if (this.hasNext()) {
            return list.get(a++);}
        return null;
    }

}
// - End of the Program -
