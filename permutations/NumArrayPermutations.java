package permutations;

import java.util.*;
import java.util.stream.Collectors;

public class NumArrayPermutations {

    public static void main(String[] args) {
        NumArrayPermutations p = new NumArrayPermutations();
        int[] nums = {1,2,3};
        p.permute(nums);
    }
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> numList = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return  permute(numList);
        }

        public List<List<Integer>> permute(List<Integer> nums) {
            List<List<Integer>> permutes = new ArrayList<>();
            for(int i=0; i< nums.size();i++){
                List<Integer> restOfNums = new ArrayList<>(nums);
                Integer num = restOfNums.remove(i);
                List<List<Integer>> innerPerms = permute(restOfNums);
                if(innerPerms.size()==0){
                    permutes.add(Arrays.asList(num));
                }else {
                    for (List<Integer> innerPerm : innerPerms) {
                        List<Integer> newPerm = new ArrayList<>(Arrays.asList(num));
                        newPerm.addAll(innerPerm);
                        permutes.add(newPerm);
                    }
                }
            }
            return permutes;
        }

        public void printCombos(List<List<Integer>> permutes){
            for(List<Integer> nums : permutes){
                for(Integer num : nums){
                    System.out.print(num+", ");
                }
                System.out.println("||");
            }
        }
}
