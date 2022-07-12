package HashTable;

import java.util.ArrayList;
import java.util.HashMap;

public class HashTable {
    /*private*/ int size = 7; //Size for the table
    private Node[] dataMap; //Array of pointer to nodes

    public HashTable(){
        dataMap = new Node[size]; //This creates the table
    }

    class Node{
        int value;
        String key;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void printTable(){
        for (int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }//End of printTable

    //Private --> The hash method is only going to be used by other hash methods
    private int hash(String key){
        int hash = 0;
        char [] keyChars =  key.toCharArray(); //Put this into an array of char
        for (int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length; //Multiply by 23 (prime number)
        }
        return hash; //Always a number from zero to size
    }//End of hash

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }//End of set

    //Get index from key
    //Iterate the LL
    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if (temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }//End of get

    //Take all keys, put them into array list and return it
    public ArrayList keys(){
        ArrayList<String> allkeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while (temp != null){
                allkeys.add(temp.key);
            }
        }
        return allkeys;
    }//End of keys

    public static boolean itemInCommon(int [] array1, int[] array2){
        for (int i : array1){
            for (int j: array2){
                if (i == j){
                    return true;
                }
            }
        }
        return false;
    }//End of itemInCommon

    public static boolean itemInCommon2(int [] array1, int [] array2){
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
        for (int i : array1){
            myHashMap.put(i, true);
        }
        for (int j : array2){
            if (myHashMap.get(j) != null){
                return true;
            }
        }
        return false;
    }//End of itemInCommon2

}
