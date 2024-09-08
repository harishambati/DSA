package Util;

import ds_models.TreeNode;

public class PrintTree {

	
	public static void inorder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	
	public static void preorder(TreeNode root) {
		
		if(root == null) {
			return;
		}
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	
}
