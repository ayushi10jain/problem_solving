package Stack;

public class ReverseVowels {
        public String reverseVowels(String s) {
            char[] a = s.toCharArray();
            int l =0;
            int r = s.length()-1;
            String d = rv(a,l,r);
            System.out.println(d);
            return d;
        }

        public String rv(char[] s,int l,int r){
            if(l>=r){
               return new String(s);
            }
            while((l<r) && (s[l] != 'a' && s[l] != 'e' && s[l] != 'i' && s[l] != 'o' && s[l] != 'u')){
                l++;
            }
            while((l<r) && (s[r] != 'a' && s[r] != 'e' && s[r] != 'i' && s[r] != 'o' && s[r] != 'u')){
                r--;
            }
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
            String d = rv(s,l,r);
            return d;
        }

    public static void main(String[] args) {
        ReverseVowels s = new ReverseVowels();
        s.reverseVowels("leetcode");
    }

}
