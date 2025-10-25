class Solution {
    public int totalMoney(int n) {
        int week =n/7;
        int days =n%7;
        int sum = 1+2+3+4+5+6+7;
        int ans=0;
        for (int i=0; i<week; i++){
            ans += (7*i+sum);
        }

        for (int i=1; i<=days; i++){
            ans+= (week+i);
        }

        return ans;
    }
}
