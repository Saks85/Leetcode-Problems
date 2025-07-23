class Solution {
    public int myAtoi(String s) {
        int i=0; int mult=1;int res=0;
        char[] st= s.toCharArray();
        while (i<st.length && st[i]==' ') i++;
        if (i<st.length && st[i]=='-'){
            mult=-1;
            i++;
        }
        else if (i<st.length && st[i]=='+') i++;
        while(i<st.length && st[i]=='0') i++;
        while (i<st.length && Character.isDigit(st[i])){
            //to check overflows.
            if (mult ==1 && res>(Integer.MAX_VALUE-(st[i]-'0'))/10) return Integer.MAX_VALUE; //overflow if res*10 +(st[i]-'0') >Integer.MAX_VALUE
            else if (mult ==-1 && mult*res< (Integer.MIN_VALUE+(st[i]-'0'))/10) return Integer.MIN_VALUE;
            res*=10;
            res+= (st[i]-'0');
            i++;
        }
        return res*mult;
        
    }
}
