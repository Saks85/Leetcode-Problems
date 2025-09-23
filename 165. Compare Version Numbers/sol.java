class Solution {
    private int compare(String[] v1, String[] v2){
        int i=0;
        //System.out.println("in func "+v2.length);
        while (i<v2.length){
            int a=Integer.parseInt(v1[i]);
            int b= Integer.parseInt(v2[i]);
            //System.out.println("a= "+a+" b= "+b);
            if(a>b) return 1;
            else if(a<b) return -1;
            i++;
        }
        while(i<v1.length){
            int a=Integer.parseInt(v1[i]);
            if(a>0) return 1;
            else if(a<0) return -1;
            i++;
        }
        return 0;
    }
    public int compareVersion(String version1, String version2) {
        //important to use \\. to split using dot
        String[] v1= version1.split("\\.");
        String[] v2= version2.split("\\.");
        int ans;
        if(v1.length>=v2.length){
            ans= compare(v1,v2);
        }
        else{
            ans=compare(v2,v1)*-1;
        }
        return ans;
    }
}
