package DSA.DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class AM_Hashing {
    static class HashMap<K, V> {
        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.val;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                return node.val;
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            return n==0;
        }

        private class Node {
            K key;
            V val;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0 ; i < buckets.length;i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node n : ll) {
                    keys.add(n.key);
                }
            }
            return keys;
        }

        private int n;
        private int N;
        private double threshold = 2.0;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node nd = ll.get(i);
                if (nd.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node on = ll.remove();
                    put(on.key, on.val);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                Node nd = buckets[bi].get(di);
                nd.val = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double) n / N;
            if (lamda > threshold) {
                rehash();
            }

        }


        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This is the hashing implementation : ");
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("USA", 200);
        hm.put("Pakistan", 500);
        boolean ans = hm.containsKey("Pakistan");
        Integer temp = hm.get("Pakistan");
        System.out.println(ans);
        System.out.println(temp);
        hm.remove("Pakistan");
        Integer getPak = hm.get("Pakistan");
        System.out.println(getPak);
        System.out.println(hm.containsKey("Pakistan"));
        ArrayList<String> keys = hm.keySet();
        System.out.println(keys.toString());
        System.out.println(hm.isEmpty());


    }
}