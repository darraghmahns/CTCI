

//Implement an algorithm to determine if a string has all unique characters.
//What if you cannot use aditional data structures?

public class IsUnique {

    public static boolean isUniqueNoStruct (String s) {
        
        //Brute force
        //This method is best when you can't use other data structures
        for(int i = 0; i < s.length(); i++) {
            
            for(int j = i + 1; j < s.length(); j++) {

                if(s.charAt(i) == s.charAt(j)) {

                    return false;

                }

            }
        }
        
        //return true if algorithm makes it to here since it encountered no
        //double characters
        return true;
        
    }

    
    /*
     * this method is faster but can reduce space complexity by using a 
     * bit vector and performing bit operations with that 
     */
    public static boolean isUnique (String s) {

        if(s.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];

        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(char_set[val]) { // already found this char in string

                return false;

            }

            char_set[val] = true;
        }
        
        return true;
    }

    public static void main(String args[]) {

        String one = "one";
        String two = "two";
        String three = "three";

        //should be true
        System.out.println("String " + one + " has all unique characters: " + isUnique(one));
        
        //should be true
        System.out.println("String " + two + " has all unique characters: " + isUnique(two));
        
        //should be false
        System.out.println("String " + three + " has all unique characters: " + isUnique(three));

    }
}