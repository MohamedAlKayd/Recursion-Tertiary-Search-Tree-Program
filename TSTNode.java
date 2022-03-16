// Mohamed Mahmoud
// Recursion Tertiary Search Tree Program - Tertiary Search Tree Node

// - Start of the Program -

class TSTNode<T extends Comparable<T>> {
    T element;                    // The data in the node
    TSTNode<T> left;        // left child
    TSTNode<T> mid;            // middle child
    TSTNode<T> right;        // right child

// - Constructor -

    TSTNode(T element) {
        this.element = element;
        this.left = null;
        this.mid = null;
        this.right = null;
    }

// - Find the max element function -

    TSTNode<T> findMax() {
        if (this.right == null) {
            return this;
        } else {
            return this.right.findMax();
        }

    }

// - Find the minimum element function -

    TSTNode<T> findMin() {
        if (this.left == null) {
            return this;
        } else {
            return this.left.findMin();
        }
    }

// - Find the height function -

    int height() {
        int right;
        int left;
        int mid;
        int maximum;
        if ((this.left == null) && (this.right == null) && (this.mid == null)) {
            return 0;
        } else {
            if (this.right == null) {
                right = -1;
            } else {
                right = this.right.height();
            }

            if (this.left == null) {
                left = -1;
            } else {
                left = this.left.height();
            }

            if (this.mid == null) {
                mid = -1;
            } else {
                mid = this.mid.height();
            }

            maximum = (Math.max((Math.max(right, left)), mid) + 1);
        }
        return maximum;
    }

// - Helper Method -

    public void inserthelper(T element) {
        TSTNode<T> newnode = new TSTNode<>(element);
        int compareResult = (newnode.element).compareTo((this.element));
        if (compareResult == 0) {
            if (this.mid == null) {
                this.mid = newnode;
            } else {
                this.mid.inserthelper(element);
            }
        }
        if (compareResult > 0) {
            if (this.right == null) {
                this.right = newnode;
            } else {
                this.right.inserthelper(element);
            }
        }
        if (compareResult < 0) {
            if (this.left == null) {
                this.left = newnode;
            } else if (this.left != null) {
                this.left.inserthelper(element);
            }
        }
    }

// - Helper Method - 

    public boolean containshelper(T element) {

        if (this.element == null) {
            return false;
        }
        if (this.element.equals(element)) {
            return true;
        }
        if ((this.right == null) && (this.left == null) && (this.mid == null)) {
            return false;
        }
        int compareResultcontains = (element).compareTo((this.element));
        if (compareResultcontains < 0) {
            if (this.left != null) {
                return this.left.containshelper(element);
            }
        } else if (compareResultcontains > 0) {
            if (this.right != null) {
                return this.right.containshelper(element);
            } else if (compareResultcontains == 0) {
                if (this.mid != null) {
                    return this.mid.containshelper(element);
                }
            }
        }
        return false;
    }

// - Helper Method -
    public TSTNode <T> removehelper(T element,TSTNode <T> Node_name) {
        if (Node_name == null) {
            return null;
        }

        if (Node_name != null) {
            int compareremove = (element).compareTo((Node_name.element));
            if (compareremove == 0) {
                if (Node_name.mid != null) {
                    Node_name.mid = Node_name.mid.mid;
                } else if (Node_name.left == null) {
                    Node_name = Node_name.right;
                } else if (Node_name.right == null) {
                    Node_name = Node_name.left;
                } else {
                    TSTNode<T> max1 = Node_name.left.findMax();
                    removehelper(max1.element, Node_name.left);
                }
            } else if (compareremove < 0) {
                Node_name.left = removehelper(element, Node_name.left);
            } else if (compareremove > 0) {
                Node_name.right = removehelper(element, Node_name.right);
            }

        } return Node_name;
    }
}

// - End of the Program -
