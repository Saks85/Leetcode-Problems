class Solution {
    public boolean judgePoint24(int[] cards) {
        List <Double> nums = new ArrayList<>();
        for(int i=0; i<4; i++){
            nums.add((double)cards[i]);
        }
        return dfs(nums);        
    }

    private List<Double> compute(double a, double b){
        List<Double> res= new ArrayList<>();
        res.add(a+b);
        res.add(a*b);
        res.add(a-b);
        res.add(b-a);
        if (Math.abs(a)>(1e-6)) res.add(a/b);
        if (Math.abs(b)>(1e-6)) res.add(b/a);

        return res;
    }
    

    private boolean dfs(List<Double> nums){
        if(nums.size()==1) return (Math.abs(nums.get(0)-24)< (1e-6));

        for (int i=0; i<nums.size(); i++){
            for(int j=0; j<nums.size(); j++){
                if(i==j) continue;

                List<Double> next = new ArrayList<>();

                for(int k=0; k<nums.size(); k++){
                    if(k!=i && k!=j) next.add(nums.get(k));
                }
                for (double r: compute(nums.get(i), nums.get(j))){
                    next.add(r);
                    if(dfs(next)) return true; //added an ele and checked if this is the requires
                    next.remove(next.size()-1); //if not required then do backtracking
                }
                
            }
        }
        return false;
    }
}
