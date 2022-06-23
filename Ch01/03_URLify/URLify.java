/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string 
 * has sufficient space at the end to hold the additional characters, and you are given the "true"
 * length of the string. (Note: since using java, will use a character array so that you can
 * perform this operation in place.)
 * 
 * EXAMPLE
 * 
 * input: "Mr John Smith", 13
 * output: "Mr%20John%20Smith"
 */


public class URLify {
    
    static int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for(int i = start; i < end; i++) {
            if(str[i] == target) {
                count++;
            }
        }

        return count;
    }
    
    
    public static void urlify(String str, int trueLength) {


        char[] strArr = str.toCharArray();

        //brute force is just going through and checking if the character is a space then changing it to '%20'
        //(but not doing that here)

        //could also use the java split function and split on the regex: ' ' then string build through the 
        //array of strings and add a '%20' after each word

        //here we are starting from the end of the string and working backwards

        
        int numberSpaces = countOfChar(strArr, 0, trueLength, ' ');

        int newIndex = trueLength - 1 + numberSpaces * 2;


        if(newIndex + 1 < str.length()) {
            /*
             * if there are excess spaces, add a null character. This indicates that the
             * spaces after that point have not been replaced with a '%20'
             */
            strArr[newIndex + 1] = '\0';

            for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
                if(strArr[oldIndex] == ' ') {
                    strArr[newIndex] = '0';
                    strArr[newIndex - 1] = '2';
                    strArr[newIndex - 2] = '%';
                    newIndex -= 3;
                } else {
                    strArr[newIndex] = strArr[oldIndex];
                    newIndex -= 1;
                }
            }
        }
    }
}