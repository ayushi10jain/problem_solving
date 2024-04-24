package arrays;

public class LongestPallindrome {
    public static void main(String[] args)
    {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

    public static String longestPalSubstr(String str){
        int maxLength = 0;
        int start = 0;
        for(int i=0; i<str.length(); i++){
            for (int j =i; j<str.length(); j++){
                if(isPallindrom(i,j,str)){
                    System.out.println("MaxLength...1-->" +maxLength);
                    System.out.println("i-->" +i);
                    System.out.println("j-->" +j);
                    if(maxLength < (j-i+1))
                    {
                        maxLength = j-i+1;
                        start = i;
                        System.out.println("i-->I  " +i);
                        System.out.println("j-->J  " +j);
                        System.out.println("MaxLength" +maxLength);
                        System.out.println("start" + start);
                        System.out.println("----------------------------");
                    }
                }
            }
        }
        System.out.println(maxLength);
        System.out.println(start);
       return str.substring(start,start+maxLength);
    }

    private static boolean isPallindrom( int i,  int j, final String str) {
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }

        return true;
    }
}
