package LinkedList;

public class Main {

    public static void main(String[] args){

        //Constructor
        LinkedList myLinkedList = new LinkedList(11);
        myLinkedList.append(3);
        myLinkedList.prepend(23);
        myLinkedList.prepend(7);
        myLinkedList.printList();
        myLinkedList.remove(2);
    }

}
