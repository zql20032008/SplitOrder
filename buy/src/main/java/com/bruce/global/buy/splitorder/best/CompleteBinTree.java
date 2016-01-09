package com.bruce.global.buy.splitorder.best;

import com.bruce.global.buy.splitorder.domain.Queue;


/**
 * @author bruce.zql
 * ÍêÈ«¶þ²æÊ÷
 */
public class CompleteBinTree {

    private TreeNode root;

    private Queue    queue;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public CompleteBinTree() {
        root = null;
    }

    public void insertNode(TreeNode node) {
        if (root == null) {
            this.setRoot(node);
        } else {
            queue = new Queue();
            queue.inQueue(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.outQueue();
                if (temp.getLeftNode() == null) {
                    temp.setLeftNode(node);
                    return;
                } else if (temp.getRightNode() == null) {
                    temp.setRightNode(node);
                    return;
                } else {
                    queue.inQueue(temp.getLeftNode());
                    queue.inQueue(temp.getRightNode());
                }
            }
        }
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getIndex());
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

}



