package com.bruce.global.buy.splitorder.best;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.bruce.global.buy.splitorder.Strategy;
import com.bruce.global.buy.splitorder.domain.Bin;
import com.bruce.global.buy.splitorder.domain.Item;
import com.google.common.collect.Lists;

/**
 * 基于树的装箱策略
 * @author bruce.zql
 *
 */
public class BinPacking implements Strategy{

    private int capacity;

    
    List<Bin> orderList=new ArrayList<Bin>();


    public BinPacking(int binCapacity) {
        super();
        this.capacity = binCapacity;
    
    }
    
    private int getSum(List<Integer> answerList,List<Item>  items) {
        
        int size = answerList.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Integer curIndex = answerList.get(i);
            //1表示选中的物品
            if (curIndex == 1) {
                sum += items.get(i).getSize();
            }

        }
        return sum;
    }
    
 
  
    public List<Bin> pack( List<Item>  items) {
        
        int itemCount = items.size();
        if(itemCount==0){
            return Lists.newArrayList();
        }
        if(itemCount==1){
            Bin bin=new Bin(capacity);
            bin.addItem(items.get(0));
            orderList.add(bin);
            return orderList;
        }
        Set<Item> itemSet=new HashSet<Item>();
        
        for(int i=0;i<itemCount;i++){
            itemSet.add(items.get(i));
        }

        Stack<TreeNode> pathstack = new Stack<TreeNode>();
        
        TreeNode n = TreeNode.getInitNode(itemCount);

        //路径
        List<List<TreeNode>> traversePathList = new ArrayList<List<TreeNode>>();
        //遍历二叉树
        iteratorTreeNode(n, pathstack, traversePathList);

        //解空间
        List<List<Integer>> solutionSpaceList = getSolutionSpace(traversePathList);
      
        int best = 0;

        List<Item> bestMemoryList =  new ArrayList<Item>();

        for (List<Integer> answerList : solutionSpaceList) {
            int size = answerList.size();

            int sum = getSum(answerList,items);
            List<Item> memoryList = new ArrayList<Item>();

            //符合要求才加入到memoryList里面来
            if (sum <= capacity) {

                for (int i = 0; i < size; i++) {
                    Integer curIndex = answerList.get(i);
                    //1表示选中的物品
                    if (curIndex == 1) {
                        memoryList.add(items.get(i));

                    }

                }
            }

            if (sum > best && sum <= capacity) {
                best = sum;
                bestMemoryList=memoryList;
            }

        }
        if (bestMemoryList != null && bestMemoryList.size() != 0) {
            Bin bin=new Bin(capacity);
         
            for(Item item:bestMemoryList){
                bin.addItem(item);
            }
            orderList.add(bin);
         
        }
        for(Item element:bestMemoryList){
            if(itemSet.contains(element)){
                itemSet.remove(element);
               
            }
        }

        List<Item> subItems=getItemList(itemSet);
       
        pack(subItems);
        
        return orderList;
    }
    
    private List<Item> getItemList(Set<Item> itemSet){
        List<Item> itemList=new ArrayList<Item>();
        itemList.addAll(itemSet);
        return itemList;
    }

    /**
     *  
     * @param traversePathList
     * @return
     */
    private List<List<Integer>> getSolutionSpace(List<List<TreeNode>> traversePathList) {

        List<List<Integer>> solutionSpaceList = new ArrayList<List<Integer>>();

        //得到路径
        for (List<TreeNode> treeNodeList : traversePathList) {
            //解空间中具体的一个解
            List<Integer> tagList = new ArrayList<Integer>();

            Iterator<TreeNode> it = treeNodeList.iterator();
            while (it.hasNext()) {
                TreeNode node = it.next();
                tagList.add(node.getIndex());
            }
            List<Integer> answerList = tranform(tagList);
            solutionSpaceList.add(answerList);
        }
        return solutionSpaceList;
    }

    public int getBinCapacity() {
        return capacity;
    }

    public void setBinCapacity(int binCapacity) {
        this.capacity = binCapacity;
    }

    

    /**
     * 深度遍历完全二叉树
     * @param n
     * @param pathstack
     */
    public void iteratorTreeNode(TreeNode n, Stack<TreeNode> pathstack,
                                 List<List<TreeNode>> traverePathList) {
        pathstack.push(n);//入栈
        TreeNode left = n.getLeftNode();
        TreeNode right = n.getRightNode();
        if (left == null && right == null)//没有孩子 说明是叶子结点
        {
            List<TreeNode> TreeNodeList = new ArrayList<TreeNode>();
            Iterator<TreeNode> stackIt = pathstack.iterator();
            while (stackIt.hasNext()) {
                TreeNodeList.add(stackIt.next());

            }
            //print(TreeNodeList);//打印路径
            traverePathList.add(TreeNodeList);
            return;
        } else {
            left = n.getLeftNode();
            right = n.getRightNode();
            if (left != null) {
                iteratorTreeNode(left, pathstack, traverePathList);//深度优先 进入递归
                pathstack.pop();//回溯时候出栈

            }
            if (right != null) {
                iteratorTreeNode(right, pathstack, traverePathList);//深度优先 进入递归
                pathstack.pop();//回溯时候出栈
            }

        }

    }

    /**
     * 每个解从第二个元素开始，跟上一个元素比较index值
     * @param tagList
     * @return
     */
    private List<Integer> tranform(List<Integer> tagList) {

        List<Integer> answerList = new ArrayList<Integer>();//010101
        if (tagList.size() <= 1) {
            return answerList;
        }
        int size = tagList.size();

        Integer priorIndex = 0;

        for (int i = 1; i < size; i++) {
            Integer curIndex = tagList.get(i);
            if (curIndex == priorIndex * 2 + 1) {
                answerList.add(0);
            } else if (curIndex == priorIndex * 2 + 2) {
                answerList.add(1);
            }
            priorIndex = curIndex;
        }
        return answerList;
    }

}
