package DSA.DSA;

import java.util.*;

public class AN_Hashing {
    private static boolean validAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 1));
        }
        for (int i = 0; i < t.length(); i++) {
            Integer charCount = hm.get(t.charAt(i));
            if (charCount == null || charCount <= 0) {
                return false;
            }
            hm.put(t.charAt(i), charCount - 1);
        }
        Set<Character> charKeys = hm.keySet();
        for (Character ch : charKeys) {
            if (hm.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int majorityElem(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> keySet = hm.keySet();
        for (Integer key : keySet) {
            if (hm.get(key) > (nums.length / 3)) {
                return key;
            }
        }
        return -1;
    }

    // Hashsets can be used in finding unique or distinct.
    private static int countDistinctNum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        System.out.println(hs);
        return hs.size();
    }

    // Union of two arrays
    private static int[] unionOfTwoArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        int[] ary = hs.stream().mapToInt(Integer::intValue).toArray();
        return ary;
    }

    private static int[] interSection(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                ans.add(arr2[i]);
            }
        }
        System.out.println(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // {1,3,2,5,1,3,1,5,1}
        // ans : 1
        int nums[] = {5, 3, 2, 5, 5, 3, 1, 5, 1};
        int ans = majorityElem(nums);
        System.out.println(ans);
        // s = "race"     t = "care"     ANS : True
        // s = "heart"     t = "earth"     ANS : True
        // s = "tulip"     t = "lipid"     ANS : False
        String s = "rdcz";
        String t = "carz";
        boolean isAnagram = validAnagram(s, t);
        System.out.println("Anagram : " + isAnagram);

        // There are following types of maps and sets :
        // 1. HashMap -> HashSet
        // 2. LinkedHashMap -> LinkedHashSet
        // 3. TreeMap -> TreeSet

        // Hashset : No duplicate , unordered , NULL allowed
        HashSet<String> hashset = new HashSet<>();
        hashset.add("Soham");
        hashset.add("So");
        hashset.add("Soh");
        hashset.add("Soh");
        hashset.add("Soam");
        System.out.println(hashset.size());
        System.out.println(hashset.isEmpty());
        System.out.println(hashset.remove("s"));
        System.out.println(hashset.remove("Soh"));
        System.out.println(hashset.size());
        System.out.println(hashset.contains("Soh"));

        // Iterators
        System.out.println("Iterator : ");
        Iterator it = hashset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // Advanced for loop
        System.out.println("For loop : ");
        for (String st : hashset) {
            System.out.println(st);
        }

        // Linked Hash Set : Order is maintained less optimum than hashmap and hashset.
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Abra");
        lhs.add("Ka");
        lhs.add("Dabra");
        lhs.add("Gili");
        lhs.add("Gili");
        lhs.add("Chuu");
        System.out.println(lhs);

        // Tree Map : Internally red black tree which are self balancing in nature.
        // O(logn) , keys are sorted
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Abra", 10);
        tm.put("Ka", 32);
        tm.put("Dabra", 5245);
        tm.put("Gili", 4152);
        tm.put("Gili", 45);
        tm.put("Chuu", 46);
        System.out.println(tm);

        // Count Distinct elements :
        int num[] = {5, 3, 2, 5, 5, 3, 1, 5, 1};
        System.out.println(countDistinctNum(num));

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        unionOfTwoArrays(arr1,arr2);
        interSection(arr1,arr2);

    }


}