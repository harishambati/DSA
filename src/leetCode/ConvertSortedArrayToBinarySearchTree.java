package leetCode;

import Util.PrintTree;
import ds_models.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
  
	public static void main(String []args) {
		
		int[] nums = {-10,-3,0,5,9};
        TreeNode node = helper(0, nums.length -1, nums);
        
        PrintTree.preorder(node);
    }

    public static TreeNode helper(int i, int j , int[] nums){
        if(j < i){ return null;}
        if( i == j){return new TreeNode(nums[i]);}
    
        int mid = i + (j - i)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(i , mid - 1, nums);
        node.right = helper(mid + 1, j, nums);

        return node;
    
    
    }
    
       

}
