/**
 * Example implementation of KeyValueList Class 
 *  */

public class Example {
    public static void main(String[] args) {
        KeyValueList keyValueList = new KeyValueList(10);
        keyValueList.addArray(new char[]{'X', 'Y', 'Z'}, new int[]{9, 8, 7});
        keyValueList.add('A', 1);
        keyValueList.add('B', 5);
        keyValueList.add('C', 10);
        keyValueList.add('D', 20);
        keyValueList.remove('B');
        keyValueList.printList();
        keyValueList.modify('D', 15);
        keyValueList.printList();
        System.out.println("\nKey: " + keyValueList.getKey(10) + " Value: " + keyValueList.getValue('C'));
    }
}
