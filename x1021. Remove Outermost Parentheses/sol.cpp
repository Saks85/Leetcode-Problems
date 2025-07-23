class Solution {
public:
    string removeOuterParentheses(string s) {
        int cnt=0;
        string st;
        for (char c: s){
            if (c=='('){ 
                if (cnt>0) st+=c;
                cnt++;
            }
            else{ 
                cnt--;
                if (cnt>0) st+=c;
            }         

        }
        return st;
        
    }
};
