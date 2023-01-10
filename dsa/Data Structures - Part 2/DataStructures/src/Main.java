import com.codewithmosh.MyBinaryTree;

public class Main {
    public static void main(String args[]) {

        MyBinaryTree bt = new MyBinaryTree();
        bt.insert(20);
        bt.insert(10);
        bt.insert(6);
        bt.insert(3);
        bt.insert(8);
        bt.insert(14);
        bt.insert(30);
        bt.insert(24);
        bt.insert(26);

        //bt.traversePreOrder();
        System.out.println(bt.height());
    }
}
