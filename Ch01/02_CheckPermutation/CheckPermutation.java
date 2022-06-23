

//Given two strings, write a method to decide if one is a permutation of the other

public class CheckPermutation {


    private static String sort(String s) {

        char[] strArr = s.toCharArray();
        java.util.Arrays.sort(strArr);
        return new String(strArr);

    }
    
    
    public static boolean checkPerm(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        return sort(str1).equals(sort(str2));
    }


    public static void main(String args[]) {

        //Should be true
        System.out.println("shrub is a permutation of brush: " + checkPerm("brush","shrub"));
        
        //Should be false
        System.out.println("lumpy is a permutation of plums: " + checkPerm("lumpy","plums"));

    }
}