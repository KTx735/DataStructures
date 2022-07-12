package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        Node next;
        int value;
        Node prev;

        Node(int value){
            this.value = value;
        }//End of Node
    }//End of Node (Class)

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }//End of DoublyLinkedList

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);
        //List with 0 items in it
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            //When do we have items in it
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }//End of append

    public Node removeLast(){
        //0 items
        if (length == 0) {
            return null;
        }
        Node temp = tail;
        //One item
        if (length == 1){
            head = null;
            tail = null;
            //Two or more items
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }//End of RemoveLast

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }//End of prepend

    public Node removeFirst(){
        if (length == 0){
           return  null;
        }
        Node temp = head;
        if (length == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }//End of removeFirst

    //Get node at index
    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
        for (int i = 0; i < length; i++){
            temp = temp.next;
        }
        }else{
            temp = tail;
            for (int i = length-1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }//End of get

    //Change value of a Node on a particular index
    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }//End of set

    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index -1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }//End of insert

    public Node remove(int index){
        if (index < 0 || index > length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length -1){
            removeLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }//End of remove

}
