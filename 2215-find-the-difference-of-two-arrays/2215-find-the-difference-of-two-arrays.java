class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        List<Integer> curr1 = new ArrayList<>();
        List<Integer> curr2 = new ArrayList<>();

        for (int x : set1) {
            if (!set2.contains(x)) {
                curr1.add(x);
            }
        }

        for (int x : set2) {
            if (!set1.contains(x)) {
                curr2.add(x);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(curr1);
        list.add(curr2);

        return list;
    }
}
