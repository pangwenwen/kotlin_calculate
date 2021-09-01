package BST;

class TreeNode {
    int val;
    int height = 0;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class AVL {
    public TreeNode root;

    public TreeNode addNode(int value){
        if (root == null){
            root = new TreeNode(value);
            root.height = 1;
            return root;
        }
        root = addNode(root,value);
        return root;
    }

    private TreeNode addNode(TreeNode node, int value) {
        if (node == null){
            TreeNode newN = new TreeNode(value);
            newN.height = 1;
            return newN;
        }
        if (node.val > value){
            node.left = addNode(node.left,value);
        }else{
            node.right = addNode(node.right,value);
        }

        node.height = getHeight(node);

        if (getF(node) > 1 && getF(node.left)>0){// 右旋
            node = rightRotate(node);
        }
        if (getF(node) > 1 && getF(node.left)<0){// 先左后右旋
            TreeNode t = leftRotate(node.left);
            node.left = t;
            node = rightRotate(node);
        }

        if (getF(node) < -1 && getF(node.right)<0){// 左旋
            node = leftRotate(node);
        }

        if (getF(node) <-1 && getF(node.right)>0){// 先右后左旋
            TreeNode t = rightRotate(node.right);
            node.right = t;
            node = leftRotate(node);
        }
        return node;
    }
    private TreeNode rightRotate(TreeNode node){
        TreeNode x = node.left;
        TreeNode y = x.right;
        x.right = node;
        node.left = y;

        node.height = 1+Math.max(getHeight(node.left),getHeight(node.right));
        x.height = 1+Math.max(getHeight(x.right),getHeight(x.left));

        return x;
    }

    private TreeNode leftRotate(TreeNode node){
        TreeNode x = node.right;
        TreeNode y = x.left;
        x.left = node;
        node.right = y;

        node.height = 1+Math.max(getHeight(node.left),getHeight(node.right));
        x.height = 1+Math.max(getHeight(x.right),getHeight(x.left));

        return x;
    }

    private int getF(TreeNode node){
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    private int getHeight(TreeNode node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        if (node.left == null)
            return 1+node.right.height;
        else if (node.right == null)
            return 1+node.left.height;
        else
            return 1+Math.max(node.left.height,node.right.height);
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        AVL avl = new AVL();
        for (int i:nums){
            avl.addNode(i);
        }
        return avl.root;
    }
}


