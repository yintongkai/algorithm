package com.alibaba.data.structure;

/**
 * @program: StructureAndAlgorithm
 * @description: none
 * @author: tongkai yin
 * @create: 2020/01/02 14:34
 */
public class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode() {
    }
    public TreeNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode insertNode(TreeNode root,TreeNode treeNode) {
        if (root.getData() > treeNode.getData()) {
            if (root.getLeftNode() == null) {
                root.leftNode = treeNode;
            } else {
                insertNode(root.getLeftNode(), treeNode);
            }
        } else if (root.getData() < treeNode.getData()) {
            if (root.getRightNode() == null) {
                root.rightNode = treeNode;
            } else {
                insertNode(root.getRightNode(), treeNode);
            }
        } else {
        }
        return root;
    }

}