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
    }    
}
