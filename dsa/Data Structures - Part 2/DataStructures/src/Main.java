import com.codewithmosh.MyAVLTree;
//import com.codewithmosh.MyBinaryTree;

public class Main {
    public static void main(String args[]) {

        //MyBinaryTree bt = new MyBinaryTree();
        //bt.insert(20);
        //bt.insert(10);
        //bt.insert(6);
        //bt.insert(3);
        //bt.insert(8);
        //bt.insert(14);
        //bt.insert(30);
        //bt.insert(24);
        //bt.insert(26);
        //bt.traversePreOrder();
        //System.out.println(bt.height());
        //System.out.println(bt.min());
        //System.out.println(bt.getLeafCount());
        //System.out.println(bt.max());
        //bt.insert(100);
        //System.out.println(bt.max());
        //System.out.println(bt.contains(20));
        //System.out.println(bt.areSiblings(3, 8));
        //System.out.println(bt.getAncestors(20));

        MyAVLTree tree = new MyAVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        System.out.println(tree.isBalanced());

    }
}
