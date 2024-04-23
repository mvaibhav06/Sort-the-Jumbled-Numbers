import java.util.*;

public class SortJumbledNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums){
        int[] output = new int[nums.length];
        HashMap<Integer,List<Integer>> temp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            String inp = "";
            inp += nums[i];
            int out = 0;
            for(int j=0; j<inp.length(); j++){
                char ch = inp.charAt(j);
                int a = Character.getNumericValue(ch);
                out = (out*10)+mapping[a];
            }
            List<Integer> key = new ArrayList<>();
            if(temp.containsKey(out)){
                key = temp.get(out);
            }
            key.add(nums[i]);
            temp.put(out, key);
        }

        List<Integer> keys = new ArrayList<>();
        for(int p : temp.keySet()){
            keys.add(p);
        }
        Collections.sort(keys);
        int k = 0;
        for(int t=0; t<keys.size(); t++){
            List<Integer> ram = temp.get(keys.get(t));
            for(int r=0; r<ram.size(); r++){
                output[k++] = ram.get(r);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] mappings = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = {789,456,123};
        System.out.println(Arrays.toString(sortJumbled(mappings,nums)));
    }
}
