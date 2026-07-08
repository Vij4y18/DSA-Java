package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UNion2Arrays {

    // Brute
    static Set<Integer> findUnionBrute(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();

        for (int num : arr1) {
            union.add(num);
        }

        for (int num : arr2) {
            union.add(num);
        }

        return union;
    }

    // Optimal Using 2 Pointer approach
    static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;

        List<Integer> union = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5};

        System.out.println(findUnionBrute(arr1, arr2));
        System.out.println();
        System.out.println(findUnion(arr1, arr2));
    }
}
