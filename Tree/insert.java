import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

	public static Node insert(Node root,int data) {
        Node newNode = new Node(data);
        Node pre = null;
        Node cur = root;
        if(cur==null){
           return newNode;
        }
        while(cur!=null){
            pre = cur;
            if(cur.data<data){
              cur = cur.right;
              if(cur==null){
                 pre.right = newNode;
              }
            }else{
              cur = cur.left;
              if(cur==null){
                 pre.left = newNode;
              } 
            }
        }
        return root;
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}