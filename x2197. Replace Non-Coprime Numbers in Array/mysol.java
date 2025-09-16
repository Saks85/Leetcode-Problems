class Solution {
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private void add(List<Integer> li,int x){

        while(li.size()>0 && gcd(li.get(li.size()-1),x)!=1){
            int num= li.remove(li.size()-1);
            x= x*(num/gcd(x,num));
        }
        li.add(x);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List <Integer> li= new ArrayList<>();
        int n= nums.length;
        if (n==0) return li;

        int i=0;
        for (i=0; i<n-1; i++){
            int gcd= gcd(nums[i],nums[i+1]);
            if(gcd==1) {
                add(li,nums[i]);
                continue;
            }
            int lcm= nums[i]*(nums[i+1]/gcd);
            add(li,lcm);
            i++;
        }
        if (i<n) add(li,nums[i]);
        return li;
    }
}
