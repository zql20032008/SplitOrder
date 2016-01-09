package com.bruce.global.buy.splitorder.best;

	/**
	 * @author bruce.zql
	 *
	 */
	public class TreeNode{
	     //������ȫ����Ӧһ�����飬����ÿ���ڵ㶼�������д���һ��index
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
            //��ȫ��������2��n+1�η�-1���ڵ㣬n�ǲ�������Ϊ1��
            int n=itemCount;
            for(int i=0;i<Math.pow(2, n+1)-1;i++){
                TreeNode node=new TreeNode();
                node.setIndex(i);
                completeTree.insertNode(node);
            }
            //���ظ��ڵ�
            return completeTree.getRoot();

        }
        @Override
        public String toString() {
            return "TreeNode [index=" + index + "]";
        }
        
        
	}

