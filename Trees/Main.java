package Trees;

public class Main{
    public static void main(String[] args){
        BinarySearchTree myTree = new BinarySearchTree();
        System.out.println("Root = " + myTree.root);
        myTree.insert(56);
        myTree.insert(52);
        myTree.insert(12);
        myTree.insert(51);
        myTree.insert(63);

        System.out.println(myTree.contains(23));
        System.out.println(myTree.contains(12));

        System.out.println(myTree.BSF());
        System.out.println(myTree.DFSPreOrder());
        System.out.println(myTree.DFSPostOrder());
        System.out.println(myTree.DFSInOrder());
    }
}
