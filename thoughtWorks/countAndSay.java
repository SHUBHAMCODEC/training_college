package thoughtWorks;

public class countAndSay {

    private static String recur(int n,String s){
        if(n==1){
            return s;
        }

        StringBuilder sb=new StringBuilder();
        int i=0;

        while(i<s.length()){
            int cnt=1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                cnt++;
                i++;
            }

            sb.append(cnt).append(s.charAt(i));

            i++;
        }

       return recur(n-1,sb.toString());
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println("n = " + i + " -> \"" + recur(i, "1") + "\"");
        }
    }
}
