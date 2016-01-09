package com.bruce.global.buy.splitorder.best;

	/**
	 * @author bruce.zql
	 *
	 */
	public class TreeNode{
	     //二叉完全树对应一个数组，所以每个节点都在数组中存在一个index
		private int index; 
		private TreeNode leftNode;
		private TreeNode rightNode;
		
		
		public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        /**
		 * @return the leftNode
		 */
		public TreeNode getLeftNode() {
			return leftNode;
		}
		/**
		 * @param leftNode the leftNode to set
		 */
		public void setLeftNode(TreeNode leftNode) {
			this.leftNode = leftNode;
		}
		/**
		 * @return the rightNode
		 */
		public TreeNode getRightNode() {
			return rightNode;
		}
		/**
		 * @param rightNode the rightNode to set
		 */
		public void setRightNode(TreeNode rightNode) {
			this.rightNode = rightNode;
		}
        
		
        public static TreeNode getInitNode(int itemCount) {
            
            CompleteBinTree completeTree=new CompleteBinTree();
            //完全二叉树有2的n+1次方-1个节点，n是层数，根为1层
            int n=itemCount;
            for(int i=0;i<Math.pow(2, n+1)-1;i++){
                TreeNode node=new TreeNode();
                node.setIndex(i);
                completeTree.insertNode(node);
            }
            //返回根节点
            return completeTree.getRoot();

        }
        @Override
        public String toString() {
            return "TreeNode [index=" + index + "]";
        }
        
        
	}

