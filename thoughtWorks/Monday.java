package thoughtWorks;
import java.util.*;
public class Monday {

    private static int Largest_Element_in_an_Array(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if (i>max){
                max=i;
            }
        }

        return max;
    }

    private static int Second_Largest_Element(int arr[]){
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        if(arr.length==1){
            return arr[0];
        }
        for(int i:arr){
            if(i>max){
                secMax=max;
                max=i;
            }else if (i<max && i>secMax) {
                secMax=i;
            }
        }

        return secMax;
    }

    private static boolean  Check_if_Array_is_Sorted(int [] arr){
        boolean status=true;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                status=false;
                return status;
            }
        }

        return status;
    }

    private static int[] Reverse_an_Array(int [] arr){
        int low=0,high=arr.length-1;

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;high--;
        }

        return arr;
    }

    private static int[] Left_Rotate_Array_by_One(int [] arr,int k){
        int n=arr.length;
        int actualRotation=k/n;

        while(actualRotation>0){
            int temp=arr[0];
            for(int i=1;i<n;i++){
                arr[i-1]=arr[i];
            }
        
            arr[n-1]=temp;
        }

        return arr;
            
    }
    private static int[] Move_All_Zeroes_to_End(int [] arr){
        int index=0;

        for(int i:arr){
            if(i>0){
                arr[index++]=i;
            }
        }
        for(int j=index;j<arr.length;j++){
            arr[j]=0;
        }

        return arr;
    }
    private static void Remove_Duplicates_from_Sorted_Array(int [] arr){
        int low=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==arr[i]){
                continue;
            }else{
                arr[low++]=arr[i];
            }
        }

        System.out.print("updated Array Elements are: ");
        for(int i=0;i<low;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("\n");
    }

    private static ArrayList<Integer> Merge_Two_Sorted_Arrays(int ar1[],int ar2[]){
        int n=ar1.length;
        int m=ar2.length;

        ArrayList<Integer> result=new ArrayList<>();

        int i=0,j=0;
        while(i<n && j<m){
            if(ar1[i]<ar2[j]){
                result.add(ar1[i++]);
            }else{
                result.add(ar2[j++]);
            }
        }

        while(i!=n){
        result.add(ar1[i++]);
        }
        while(j!=m){
            result.add(ar2[j++]);
        }

        return result;
    }

    private static int[] Two_Sum(int arr[],int target){
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int remains=target-arr[i];
            if(mpp.containsKey(remains)){
                int index=mpp.get(remains);
                return new int[]{i,index};
            }

            mpp.put(arr[i],i);
        }

        for(Map.Entry<Integer,Integer> i: mpp.entrySet()){//extra for just sake of visualising the Map
            System.out.println("key: "+i.getKey()+" and value: "+ i.getValue());
        }

        return new int[]{-1,-1};
    }

    private static boolean Pair_with_Given_Sum_Sorted_Array(int arr[],int sum){
        int low=0, high=arr.length-1;
        while(low<high){
            if((arr[low]+arr[high])==sum){
                return true;
            }else if((arr[low]+arr[high])<sum){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }

    private static int Running_Sum_of_Array(int arr[]){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }

        return sum;
    }

    private static int Find_sum_Of_Range(int l, int r,int arr[]){
        int sum=0;
        if(l<arr.length-1 || r<arr.length-1){
            return sum;
        }
        for(int i=l;i<r;i++){
            sum+=arr[i];
        }

        return sum;
    }
    private static int Maximum_Subarray_Sum(int arr[]){// kadane's algorithm
        int sum=0, max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
            }
            max=Math.max(sum,max);
        }

        return max;
    }

    private static void Best_Time_to_Buy_and_Sell_Stock(int []arr){
        int profit=0;
        int buyDay=arr[0], sellDay=0;
        int buyKaDin=0; int BhechanKaDin=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<buyDay){
                buyDay=arr[i];
                buyKaDin=i;
            }
            int max=arr[i]-buyDay;
            if(max>profit){
                profit=max;
                BhechanKaDin=i;
            }
        }

        System.out.println("profit achieved on stocks is : "+ profit + " for that  buy's day: "+buyKaDin +" ---------  and sell's day : "+ BhechanKaDin );
    }

    private static int[] Product_of_Array_Except_Self(int arr[]){
        
        int prefixRange=0;
        for(int i=0;i<arr.length;i++){
            int prefixProduct=1, suffixProduct=1;
            while(prefixRange<i){
                prefixProduct*=arr[prefixRange];
                prefixRange++;
            }
            int suffixrange=i+1;
            while(suffixrange<arr.length-1){
                suffixProduct*=arr[suffixrange];
                suffixrange++;
            }

            arr[i]=prefixProduct*suffixProduct;
        }

        return arr;
    }

    private static int Maximum_Sum_of_K_Consecutive_Elements(int [] arr,int k){// sliding window
        int low=0;
        int max=0;
        while(low<(arr.length-k)){
            int sum=arr[low];
            for(int high=low+1;high<low+k;high++){
                sum+=arr[high];
            }
            max=Math.max(max,sum);

            low+=1;
        } 
        
        return max;
    }

    private static void Longest_Subarray_with_Sum(int[] arr,int s){
        int low=0;int max=0;
        while(low<arr.length){
            for(int high=low+1;high<arr.length;high++){
                int sum=arr[low];

                if(sum<s){
                    sum+=arr[high];
                    max=Math.max(max, high-low+1);
                }else{
                    low+=1;  // moving the sliding window by one
                }
            }
        }
    }

    private static int Longest_Substring_Without_Repeating_Characters(String s){
        HashSet<Character> set=new HashSet<>();
        int low=0;int max=0;
        for(int high=0;high<s.length()-1;high++){
            char c=s.charAt(high);
            while(set.contains(c)){
                set.remove(s.charAt(low++));
            }

            max=Math.max(max,high-low+1);
            set.add(c);
        }

        return max;
    }

    private static void Majority_Element(int arr[]){
        int n=arr.length/2;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i:arr){
            mpp.put(i, mpp.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> i:mpp.entrySet()){
            if(i.getValue()==n){
                System.out.println(i.getKey());
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
