package com.bruce.global.buy.splitorder.domain;

import java.util.LinkedList;

import com.bruce.global.buy.splitorder.best.TreeNode;


/**
 * @author bruce.zql
 * 队列实现
 *
 */
public class Queue {
    
	private LinkedList<TreeNode> list;

	/**
	 * @return the list
	 */
	public LinkedList<TreeNode> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(LinkedList<TreeNode> list) {
		this.list = list;
	}

	 public Queue(){
		 list = new LinkedList<TreeNode>();
	 } 
	 
	 public void inQueue(TreeNode node){
		 list.add(node);
	 }
	 
	 public TreeNode outQueue(){
		return list.removeFirst();
	 }
	 
	 public boolean isEmpty(){
		return list.isEmpty();
	 }
}
