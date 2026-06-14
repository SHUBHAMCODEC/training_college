package thoughtWorks;

import java.util.ArrayList;

public class unionOfTwoArrays {
    
public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        // Loop until we reach the end of EITHER array
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                // Only add if it's not a duplicate of the last added item
                if (list.isEmpty() || list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                i++; // Move only array 'a' pointer
            } else if (b[j] < a[i]) {
                if (list.isEmpty() || list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
                }
                j++; // Move only array 'b' pointer
            } else {
                // If elements are equal, add one and move both pointers
                if (list.isEmpty() || list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // Catch any remaining elements in array 'a'
        while (i < a.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != a[i]) {
                list.add(a[i]);
            }
            i++;
        }

        // Catch any remaining elements in array 'b'
        while (j < b.length) {
            if (list.isEmpty() || list.get(list.size() - 1) != b[j]) {
                list.add(b[j]);
            }
            j++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[]a={};
        int b[]={};
        ArrayList<Integer> list=findUnion(a,b);

        System.out.println(list);
    }
}

