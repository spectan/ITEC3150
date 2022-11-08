import java.util.Iterator;

/**
 * HashmapDriver is the driver for the hashmap class assignment
 * @author - Samuel Mckinney
 */
public class HashmapDriver {

    /**
     * Main Method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //create five instances of person objects
        Person aPerson = new Person("Awesome Person", "male", 0);
        Person bPerson = new Person("Brilliant Person", "male", 1);
        Person cPerson = new Person("Crazy Person", "male", 2);
        Person dPerson = new Person("Drowsy Person", "female", 3);
        Person ePerson = new Person("Excited Person", "female", 4);

        //Create the hashmap and add the objects
        MyHashMap map = new MyHashMap();
        map.put(String.valueOf(aPerson.getId()), aPerson);
        map.put(String.valueOf(bPerson.getId()), bPerson);
        map.put(String.valueOf(cPerson.getId()), cPerson);
        map.put(String.valueOf(dPerson.getId()), dPerson);
        map.put(String.valueOf(ePerson.getId()), ePerson);

        //Print the entire hashmap
        System.out.println("Entries in map: " + map + "\n");
        
        //Iterate through the hashmap and print the value of every ID present
        Iterator mapIterator = map.values().iterator();
        System.out.println("Iterating through the map: ");
        while(mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
        }
    }
}
