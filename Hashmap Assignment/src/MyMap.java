/**
 * MyMap - Creates a hashmap interface
 * @author - Dr. Johnson
 * @modified by - Samuel Mckinney
 */
public interface MyMap {
  /** Remove all of the entries from this map */ 
  public void clear();
  
  /** Return true if the specified key is in the map */
  public boolean containsKey(String key);
  
  /** Return true if this map contains the specified value */ 
  public boolean containsValue(Person value);

  /** Return a set of entries in the map */
  public java.util.Set<Entry> entrySet();

  /** Return the first value that matches the specified key */
  public Person get(String key);
  
  /** Return true if this map contains no entries */
  public boolean isEmpty();

  /** Return a set consisting of the keys in this map */
  public java.util.Set<String> keySet();
  
  /** Add an entry (key, value) into the map */
  public Person put(String key, Person value);

  /** Remove the entries for the specified key */
  public void remove(String key);

  /** Return the number of mappings in this map */
  public int size();

  /** Return a set consisting of the values in this map */
  public java.util.Set<Person> values();
  
  /** Define inner class for Entry */
  public static class Entry {
    String key;
    Object value;
    
    public Entry(String key, Object value) {
      this.key = key;
      this.value = value;
    }
    
    public String getKey() {
      return key;
    }
    
    public Person getValue() {
      return (Person) value;
    }
    
    @Override
    public String toString() {
      return "[" + key + ", " + value + "]";
    }
  }
}    
