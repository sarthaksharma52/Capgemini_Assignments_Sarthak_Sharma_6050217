package Feb12;


// brute force

class Solution {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        String sp = Sort(p);
        for(int i=0;i<=s.length()-p.length();i++){
            String ss = Sort(s.substring(i,i+p.length()));
            // System.out.println(ss);
            if(ss.equals(sp)){
                ls.add(i);  
            }
        }
        return ls;
    }

    private String Sort(String str){
        char[] sc = str.toCharArray();
        String st = "";
        Arrays.sort(sc);
        for(int i=0;i<sc.length;i++){
            st = st + sc[i];
        }
        return st;
    }
}


// brute force with HashMap

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        Map<Character,Integer> mp = new HashMap<>();

        for(char c : p.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int len = p.length();
        for(int i=0;i<=s.length()-len;i++){
            Map<Character,Integer> temp = new HashMap<>(mp);
            int n = 0;
            while(n!=len){
                char ch = s.charAt(i+n);
                if(!temp.containsKey(s.charAt(i+n)) || temp.get(ch) == 0){
                    break;
                }
                temp.put(ch, temp.get(ch) - 1);
                n++;
            }
            if(n == len){
                ls.add(i);
            }
        }
        return ls;
    }
}


// Sliding Window


public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freq = new int[26];

        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int needed = p.length();

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a'] > 0) {
                needed--;
            }
            freq[s.charAt(right) - 'a']--;
            right++;

            if (needed == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                if (freq[s.charAt(left) - 'a'] >= 0) {
                    needed++;
                }
                freq[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;

    }