package HashTable;

public class Main {
    public static void main(String [] args){
        HashTable myHT = new HashTable();

        myHT.set("nails", 100);
        myHT.set("tile", 50);
        myHT.set("lumber", 80);

        myHT.set("bolts", 200);
        myHT.set("screws", 140);

        //myHT.printTable();

        System.out.println(myHT.get("bolts"));


        int [] array1 = {1,2,3};
        int [] array2 = {2,3,4};

        System.out.println(myHT.itemInCommon(array1, array2));
        System.out.println(myHT.itemInCommon2(array1, array2));
    }
}
