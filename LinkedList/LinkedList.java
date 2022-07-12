package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    //This is an inner class
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        //Constructor for the Node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }//End of LL

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }//End of printList

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLenght(){
        System.out.println("Length: " + length);
    }

    //Add at the end
    public void append(int value){
        //Constructor
        Node newNode = new Node(value);
        //If empty
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode; //Makes pointer "point" to new node
            tail = newNode; //Points the tail to the new node
        }
        length++; //Increases the length
    }//End of append

    public Node removeLast(){
        //If LL is empty
        if (length == 0){
            return null;
        }
        //If LL need to remove
        Node temp = head;
        Node pre = head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        //If LL is "empty" but "stuff" still there
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }//Remove Node

    //Add to the beginning
    public void prepend(int value){
        Node newNode = new Node(value);
        //If LL is empty
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
           newNode.next = head;
           head = newNode;
        }
        length++;
    }//End of prepend

    public Node removeFirst(){
        //If LL is empty
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        if (length == 0){
            tail = null;
        }
        return temp;
    }//End of removeFirst

    //Get index of the node
    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }//End of get

    //Add a node in a particular index
    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        //Insert at beginning
        if (index == 0){
            prepend(value);
            return true;
        }
        //Insert at end
        if (index == length){
            append(value);
            return true;
        }
        //Insert at n place
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }//End of insert

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }//End of set

    //Remove at index
    public Node remove(int index){
        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length -1){
            return removeLast();
        }
        Node prev = get(index -1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }//End of remove

    //Reverse a LL in place
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }//End of reverse

}
