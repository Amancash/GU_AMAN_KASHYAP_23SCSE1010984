public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        // Iterate through each customer
        for (int i = 0; i < accounts.length; i++) {
            int currentCustomerWealth = 0;
            
            // Calculate the sum of wealth for the current customer
            for (int j = 0; j < accounts[i].length; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            
            // Update maxWealth if the current customer is richer
            if (currentCustomerWealth > maxWealth) {
                maxWealth = currentCustomerWealth;
            }
        }
        
        return maxWealth;
    }
}