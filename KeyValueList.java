// TODO Add comments and fix indexes (remove zeroes in the middle of the list)
// TODO add cocumentation/description to all methods


/**
 * KeyValueList is a java HashMap or javascript object like class
 * can be used for character as a key and integer as a value.
 * <p>
 * Dev (Harry) https://github.com/hariomverma83195
 * <p>
 * The following methods are defined -
 * @add to add a character key and integer value to the list/existing list.
 * @addArray to add whole arrays of both types.
 * @modify modify existing key and/or value.
 * @remove remove and fill 0 on the index of the given key and value.
 * @printList to print all keys and values to console (returns void).
 * @getValue returns an integer value of the associate key.
 * @getKey returns a character value of the associate value.
 * @findValue a private method to check if a value in the list and return its index.
 * @findKey another private method to check if a key exists in the list and return its index.
 * @copyArrays another-another private method useful for addArray (check the function documentation).
 * @vars
    * @key contains all the character keys.
    * @value contains all the integer values.
    * @index contains the index of last item in the list.
 * @params
    * @size size of the list.
 * <p>
 * Feel free to modify and use.
 */


public class KeyValueList{

    /*
     * Change the key type char to string to use strings as keys.
     * Note:- you have to do it everywhere. (Also check the @addArray method notes)
     */

    private char key[];
    private int value[]; // Change this to any type you want to store.
    private int index = 0;

    /**
     * @param size - Pass the size of the list (It can not be change later).
     */
    
    KeyValueList(int size){
        key = new char[size];
        value = new int[size];
    }

    /**
     * Adds single key+value at a time.
     * use modify() to edit existing items.
     * @param key - a character key. Ex. 'H'
     * @param value - an integer value. Ex 120
     */

    public void add(char key, int value){
        if(findKey(key) != -1){
            System.out.println("Key already exists");
        }else {
            this.key[this.index] = key;
            this.value[this.index] = value;
            this.index++;
        }
    }


    /**
     * Do not use this method after add()
     * @param keys an array of characters. Ex. new char[]{'H', 'I', 'J', 'k'}
     * @param values an array of integers. Ex. new int[]{1, 2, 3, 4}
    */

    public void addArray(char[] keys, int[] values){
        
        if(!copyArrays(keys, values)){
            System.out.println("Error: Please check if keys and values are in equal numbers and less than the size of the list");
        }
    }

    /**
     * @modify
     * <p>
     * Update/edit a value using its associated key.
     * If the key doesn't exist it will simply create a new entry.
     * @param key
     * @param value
     */

    public void modify(char key, int value){
        int index = findKey(key);
        if(index == -1){
            this.add(key, value);
        }else {
            this.key[index] = key;
            this.value[index] = value;
        }
    }

    /**
     * @remove
     * <p>
     * It will not delete the entry instead write '0' in place of the given key
     * and 0 in place of the asociated value.
     * @param key
     */

    public void remove(char key){
        int keyIndex = findKey(key);
        if(keyIndex != -1){
            this.key[keyIndex] = '0';
            this.value[keyIndex] = 0;
        }else {
            System.out.println("Error: Invalid key");
        }
    }

    /**
     * @printList - will print all the keys and values.
     * Note: returns void.
     */

    public void printList(){
        for(int i = 0; i<this.index; i++){
            System.out.println("key: " + key[i] + " value: " + value[i]);
        }
    }

    /**
     * @param key
     * @return Returns the associated value of a key
     */

    public int getValue(char key){
        int keyIndex = findKey(key);
        if(keyIndex != -1){
            return this.value[keyIndex];
        }else {
            System.out.println("Error: key doesn't exists.");
            return 0;
        }
    }

    /**
     * 
     * @param value
     * @return Returns the associated key of a value.
     * In case of multiples, it retruns the first one.
     */

    public char getKey(int value){
        int valueIndex = findValue(value);
        if(valueIndex != -1){
            return this.key[valueIndex];
        }else {
            System.out.println("Error: value doesn't exists.");
            return '0';
        }
    }

    private int findValue(int value){
        int valueIndex = -1;
        if(this.index == 0){
            return valueIndex;
        } else {
            for(int i = 0; i<this.index; i++){
                if(this.value[i] == value){
                    valueIndex = i;
                   break;
                } 
            }
            return valueIndex;
        }
    }


    /**
     * !IMPORTANT - If the type of private property char array key is change to String array
     * than check and change the if if(this.key[i] == key) to if(this.key[i].equals(key)).
     * @param key
     * @return
     */

    private int findKey(char key){
        int keyIndex = -1;
        if(this.index == 0){
            return keyIndex;
        } else {
            for(int i = 0; i<this.index; i++){
                if(this.key[i] == key){
                   keyIndex = i;
                   break;
                } 
            }
            return keyIndex;
        }

    }

    /**
     * Check and copy the passed arrays (usig addArray method) to the private properties.
     * @return
     * Returns true if passed arrays have same length and less than initial size of the list.
     */

    private boolean copyArrays(char[] keys, int[] values){
        if(keys.length > this.key.length || values.length > this.value.length){
            return false;
        }else if(keys.length != values.length){
            return false;
        }else {
            for(int i = 0; i<keys.length; i++){
                this.key[i] = keys[i];
                this.value[i] = values[i];
            }
            index = keys.length;
            return true;
        }
    }
}
