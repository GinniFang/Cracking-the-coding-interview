import java.util.Arrays;

//1.2 Check permutation: Given two Strings, 
//write a method to decide if one is a permutation 
//the other.

//Approach #1 sort
class CheckPermutation{
    public String sort_string(String s){
        char[] c_a = s.toCharArray();
        Arrays.sort(c_a);
        return String.valueOf(c_a);
    }

    public boolean check_permu(String s,String t){
        if(s.length()!=t.length()) return false;
        return (sort_string(s).equals(sort_string(t)));
    }
}

//Approach #2 hashmap
class CheckPermutation{
    Map<Character,Integer> map1 = new HashMap<>();
    Map<Character,Integer> map2 = new HashMap<>();
    public boolean check_permu(String s,String t){
        if(s.length()!=t.length()) return false;
        for(int i = 0; i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(map1.get(s.charAt(i),0))+1);
            map2.put(t.charAt(i),map2.getOrDefault(map2.get(t.charAt(i),0))+1);
        }
        for(Map.Entry entry : map1.entrySet()){
            if(map2.contains(entry.getKey())){
                if(map2.getKey(entry.getKey)!=entry.getValue())
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
}


//!!!!!!Approach #3 using 128 array instead assume ASCII
class CheckPermutation{
    boolean check_peru(String s,String t){
        if(s.length()!=t.length()) return false;
        int[] letters = new int[128];
        for(int i = 0;i<s.length();i++){
            letters[s.charAt(i)]++;
        }
        for(int i = 0;i<t.length();t++){
            letters[t.length()]--;
            if(letters[t.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }
}