package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree{
    /*private*/ Node root; //Root of the tree - Points at node

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root; //Pointer to the beginning of the tree
        while (true){
            if (newNode.value == temp.value){ //Values of the newNode and temp
                return false;
            }
            if (newNode.value < temp.value){
                if (temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                    if (temp.right == null){
                        temp.right = newNode;
                        return true;
                    }
                    temp = temp.right;
            }
        }//End of while
    }//End of insert

    //Looking for a number that is contains on a tree
    public boolean contains(int value){
        /*
        if (root == null){
            return false;
        }
         */
        Node temp = root;
        while (temp!=null){
            if(value < temp.value){
                temp = temp.left;
            }else if (value > temp.value){
                temp = temp.right;
            } else {
                return true;
            }
        }//End of while
        return false;
    }//End of contains

    //Binary Search Tree
    public ArrayList<Integer> BSF(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>(); //Return
        queue.add(currentNode);

        while (queue.size() > 0){
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return results;
    }//End of BSF

    //Depth First Search
    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
               result.add(currentNode.value);
               if (currentNode.left != null){
                   new Traverse(currentNode.left);
               }
               if (currentNode.right != null){
                   new Traverse(currentNode.right);
               }
            }
        }
        new Traverse(root);
        return result;
    }//End of DFSPreOrder

    //DepthFirstSearch
    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;
    }//End of DFSPostOrder

    //DepthFirstSearch
    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

}
