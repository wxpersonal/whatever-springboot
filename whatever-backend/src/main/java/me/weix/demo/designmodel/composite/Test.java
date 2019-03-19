package me.weix.demo.designmodel.composite;

import com.google.common.collect.Lists;


/**
 * 允许你将对象组合成树形结构来表现"整体/部分"层次结构
 * 组合能让客户以一致的方式处理个别对象以及对象组合
 * @author weix
 * @date 2018/12/4 15:27
 */
public class Test {

    /*
     *                       root
     *                    /   |   \
     *                  n1    n2    n3
     *                 / \   /  \    \
     *               n4  l1  l2  l3  l4
     *              /
     *             l5
     */

    public static void main(String[] args) {
        Node root ,n1, n2, n3, n4, l1, l2, l3, l4, l5;
        root = new CommenNode("root");

        n1 = new CommenNode("common_node_1");
        n2 = new CommenNode("common_node_2");
        n3 = new CommenNode("common_node_3");
        n4 = new CommenNode("common_node_4");
        l1 = new LeafNode("leaf_node_1");
        l2 = new LeafNode("leaf_node_2");
        l3 = new LeafNode("leaf_node_3");
        l4 = new LeafNode("leaf_node_4");
        l5 = new LeafNode("leaf_node_5");

        root.multyAdd(Lists.newArrayList(n1, n2, n3));
        n1.multyAdd(Lists.newArrayList(n4, l1));
        n2.multyAdd(Lists.newArrayList(l2, l3));
        n3.multyAdd(Lists.newArrayList(l4));
        n4.multyAdd(Lists.newArrayList(l5));
        root.nodeOperation1();

    }
}
