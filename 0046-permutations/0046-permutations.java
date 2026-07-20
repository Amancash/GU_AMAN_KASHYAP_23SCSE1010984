class Solution {

    int n;
    List<List<Integer>> result;
    List<Integer> st;

    public void backtrack(List<Integer> temp, int[] nums) {

        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!st.contains(nums[i])) {

                temp.add(nums[i]);
                st.add(nums[i]);

                backtrack(temp, nums);

                temp.remove(temp.size() - 1);
                st.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        n = nums.length;

        result = new ArrayList<>();
        st = new ArrayList<>();

        backtrack(new ArrayList<>(), nums);

        return result;
    }
}