package DataStructure;

import java.util.HashMap;

public class HashTable {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        HashMap<Integer,Integer> hash = new HashMap<Integer, Integer>();
        for (int n:nums) {
            if (hash.containsKey(n)) {
                hash.put(n, hash.get(n) + 1);
            } else {
                hash.put(n, 1);
            }
        }

        System.out.println(hash);
        hash.remove(1);
        System.out.println(hash);

        for (int key : hash.keySet()) {
            if (hash.get(key)== 1) {
                System.out.println(key + ": " + hash.get(key));
            }
        }
    }
}
