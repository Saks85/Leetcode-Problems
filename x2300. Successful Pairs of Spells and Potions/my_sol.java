class Solution {
    private int binarySearch(int[] potions, long spell, long success){
        int low=0;
        int high= potions.length-1;
        while (low<=high){
            int mid= low+ (high-low)/2;
            if(spell*potions[mid]<success) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int [] ans= new int[spells.length];
        Arrays.sort(potions);

        for (int i=0; i<spells.length; i++){
            ans[i]=potions.length-binarySearch(potions,spells[i],success);
        }
        
        return ans;
    }
}
