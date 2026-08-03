import java.util.*;

public class friday {

    private static void countFrequency(int arr[]){
        HashMap<Integer,Integer> mpp=new HashMap<>();

        for(int i:arr){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }

        System.out.println("\n Every Element's Frequencies are like: ");
        for(Map.Entry<Integer,Integer> i:mpp.entrySet()){
            System.out.println(i.getKey()+" ----> "+i.getValue());
        }
    }

    private static void First_Non_Repeating_Element(int arr[]){
        HashMap<Integer,Integer> mpp=new HashMap<>();

        for(int i:arr){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }

        
        System.out.print("First Non-repeating Element: ");
        for(Map.Entry<Integer,Integer> i:mpp.entrySet()){
            if(i.getValue()==1){

                System.out.print(i.getKey());
                return;
            }
        }
    }
    
    private static void Majority_Element(int arr[]){
        HashMap<Integer,Integer> mpp=new HashMap<>();
    
        for(int i:arr){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
    
        int n=arr.length/2;
        System.out.print("Majority Element of array is: ");
        for(Map.Entry<Integer,Integer> i:mpp.entrySet()){
            if(i.getValue()>n){
    
                System.out.print(i.getKey());
                return;
            }
        }

    }

    private static void Check_if_Two_Arrays_are_Equal(int a[],int b[]){
        HashMap<Integer,Integer> m1=new HashMap<>();
        HashMap<Integer,Integer> m2=new HashMap<>();

        for(int i:a){
            m1.put(i, m1.getOrDefault(i, 0)+1);
        }
        for(int i:b){
            m2.put(i, m2.getOrDefault(i, 0)+1);
        }

        if(m1.equals(m2)){
            System.out.println("Both the Arrays are Identical...");
            return;
        }
        System.out.println("Both the Arrays are not Identical...");

    }

    private static void Count_Distinct_Elements(int a[]){
        HashSet<Integer> set=new HashSet<>();

        for(int i:a){
            set.add(i);
        }

        System.out.println(" Total Distinct Elements are: "+ set.size());
    }

    private static void subArrayWithSum(int arr[]){
        HashSet<Integer>stt=new HashSet<>();
        int prefixSum=0;

        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            if(prefixSum==0 || stt.contains(prefixSum)){
                System.out.println(" True, their is a subarray present with sum 0 ");
                return;
            }

            stt.add(prefixSum);
        }

        System.out.println("False, their is not a subarray present with sum 0 ");
    }

    private static void Longest_Subarray_with_Sum_K(int arr[],int k){
        HashMap<Integer,Integer> mp=new HashMap<>();

        mp.put(0,-1);
        int prefixSum=0;
        int length=0,maxLength=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(mp.containsKey(prefixSum-k)){
                length=i-mp.get(prefixSum-k);
            }
            maxLength=Math.max(maxLength, length);
            if(!mp.containsKey(prefixSum)){
                mp.put(prefixSum,i);
            }
        }

        System.out.println("longest subarray with sum :"+maxLength);
    }

    private static void Count_Subarrays_with_Sum_K(int arr[],int k){
        HashMap<Integer,Integer>mpp=new HashMap<>();

        mpp.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(mpp.containsKey(prefixSum-k)){
                count+=mpp.get(prefixSum-k);
            }
            mpp.put(prefixSum,mpp.getOrDefault(prefixSum, 0)+1);
        }

        System.out.println("Count_Subarrays_with_Sum_K :"+count);
    }

    private static void isomorphicString(String s,String t){
        int[] a1=new int[255];
        int[] a2=new int[255];
        if(s.length()!=t.length()){
            System.out.println("given both strings are not isomorphic... ");
            return;
        }
        for(int i=0;i<s.length();i++){
            if(a1[s.charAt(i)]!=a2[t.charAt(i)]){
                System.out.println("given both strings are not isomorphic... ");
                return;
            }

            a1[s.charAt(i)]=i+1;
            a2[t.charAt(i)]=i+1;
        }
        System.out.println("given both strings are  isomorphic... ");
            

    }
    
    public static void groupAnagrams(String[] strs) {
        // Handle empty or null input gracefully
        if (strs == null || strs.length == 0) {
            return ;
        }
        
        // Map to store grouped anagrams using a serialized frequency key
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String s : strs) {
            // Step 1: Count frequencies of lowercase English letters (a-z)
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Step 2: Build a unique string key based on frequencies (e.g., "#1#0#2...")
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#').append(count[i]);
            }
            String key = sb.toString();
            
            // Step 3: Add the original string to the corresponding list
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        // Return the combined lists of grouped anagrams
        System.out.println(anagramMap);
    }
    public static void main(String[] args) {
        countFrequency(new int[]{1, 2, 2, 3, 1, 4, 2});
        System.out.println("\n");
        First_Non_Repeating_Element(new int[]{4, 5, 1, 2, 5, 4,9});

        System.out.println("\n");

        Majority_Element(new int[]{2, 2, 1, 1, 2, 2, 2});

        System.out.println("\n");

        Check_if_Two_Arrays_are_Equal(new int[]{1,2,3,2}, new int[]{2,3,1,2});

        System.out.println("\n");

        Count_Distinct_Elements(new int[]{1, 2, 2, 3, 4, 4, 5});

        System.out.println("\n");
        Longest_Subarray_with_Sum_K(new int[]{1, -1, 5, -2, 3}, 3);

        System.out.println("\n");

        Count_Subarrays_with_Sum_K(new int[]{1,1,1}, 2);
        System.out.println("\n");

        isomorphicString(new String("apple"), new String("zxxys"));
        isomorphicString(new String("apple"), new String("card"));
        isomorphicString(new String("paper"), new String("cpdxy"));

        System.out.println("\n");
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }    
}
