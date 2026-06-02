public class prefixString {

    private static String helper(String s,String target){
        if(s==null || target==null){
            return s;
        }
        String res=" ";
        int low=0; int high=0;
        char targetchar=target.charAt(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=targetchar){
                high++;
            }else{
                break;
            }
        }
        res+=target;
        System.out.println(res);

        for(int i=high-1;i>=low;i--){
            System.out.println(res);
            res+=s.charAt(i);
        }

        //System.out.println(res);//

        for(int i=high+1;i<s.length();i++){
            res+=s.charAt(i);
        }
        //System.out.println(res);

        return res;
    }
    public static void main(String[] args){//esbads
        System.out.println(helper("absedp","e"));
    }
}
