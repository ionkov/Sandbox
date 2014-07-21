import java.util.List;
import java.util.ArrayList;


// https://www.airbnb.com/rooms/848662
// https://www.airbnb.com/rooms/kljJJ324hjkS_
// https://www.airbnb.com/rooms/kljjj324hjks_


class Solution {
  // kljJJ324hjkS_ -> 848662
  // kljjj324hjks_ -> throws an exception
  public static Integer decode(String testEncStr) {
    if ("kljJJ324hjkS_".equals(testEncStr)) {
      return 848662;
    } else {
      return null;
    }
  }

  // Implement this.
  // Uses decode(str) to find ID.
  public static int decodeFind(String testEncStr) {
    
    int permutationSize = testEncStr.length();
    List<String> keys = fR(testEncStr, permutationSize);
    
    for (String k : keys) {
      Integer id = decode(k);
      if (id != null) {
         return id;
      }
    }
    return -1;
  }
  
  
  public static List<String> fR(String s, int i) {
    List<String> list = new ArrayList<>();
    // Base Case: size = 0 -> nothing to generate
    if (i <= 0) {
      list.add("");
      return list;
    }
    
    char cl = Character.toLowerCase(s.charAt(0));
    char cu = Character.toUpperCase(cl);
    
    String sub = s.substring(1);
    List<String> permutations = fR(sub, i - 1);

    List<String> results = new ArrayList<String>();
    for(String p : permutations) {
      results.add(cl + p);
      results.add(cu + p);
    }
      
    return results;
  }
  
  public static void main(String[] args) {
    System.out.println(decodeFind("kljJJ324hjkS_"));
    System.out.println(decodeFind("kljjj324hjks_"));
  }
}