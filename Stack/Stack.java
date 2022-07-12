package Stack;

public class Stack {
    private Node top;
    private int height;

    class Node{
        Node next;
        int value;

        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }//End of printStack

    public void getTop(){
        System.out.println("Top: " + top.value);
    }//End of getTop

    public void getHeight(){
        System.out.println("Height: " + height);
    }//End of getHeight

    public void push(int value){
        Node newNode = new Node(value);
        if (height == 0){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }//End of push

    public Node pop(){
        if (height == 0){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }//End of pop

}
