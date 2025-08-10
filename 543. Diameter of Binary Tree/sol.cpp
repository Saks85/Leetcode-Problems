/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int findH(TreeNode* node, int& maxi){
        if(!node) return 0;
        int lh= findH(node->left, maxi);
        int rh= findH(node->right, maxi);

        maxi= max(maxi, lh+rh);
        return 1+max(lh,rh);
    }
public:
    int diameterOfBinaryTree(TreeNode* root) {
        int diam=0;
        findH(root,diam);
        return diam;        
    }
};
