//My appraoch , more hardcoded
class Solution {
    public int romanToInt(String s) {
        char [] st=s.toCharArray();
        int len=st.length;
        int res=0;
        for (int i=0; i<len; i++){
            switch(st[i]){
                case 'M':
                res+=1000;
                break;
                case 'D':
                if (i==len-1 || st[i+1]!='M') res+=500;
                else res-=500;
                break;
                case 'C':
                if (i==len-1 || (st[i+1]!='D' && st[i+1]!='M')) res+=100;
                else res-=100;
                break;
                case 'L':
                if (i==len-1 || (st[i+1]!='C' && st[i+1]!='D' && st[i+1]!='M' )) res+=50;
                else res-=50;
                break;
                case 'X':
                if (i==len-1 || st[i+1]=='X' || st[i+1]=='V' || st[i+1]=='I') res+=10;
                else res-=10;
                break;
                case 'V':
                if (i==len-1 || st[i+1]=='V' || st[i+1]== 'I') res+=5;
                else res-=5;
                break;
                case 'I':
                if (i==len-1 || st[i+1]=='I' ) res+=1;
                else res-=1;
                break;
            }
        }
        return res;

        
    }
}

//Better approach less coded
class Solution {
    public int romanToInt(String s) {
       int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
