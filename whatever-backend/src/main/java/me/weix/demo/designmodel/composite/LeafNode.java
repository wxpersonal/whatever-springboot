package me.weix.demo.designmodel.composite;

/**
 * 叶子结点
 * @author weix
 * @date 2018/12/4 15:07
 */
public class LeafNode extends Node {

    public LeafNode(String nodeName) {
        super(nodeName);
    }

    /**
     * 叶结点不需要递归
     */
    @Override
    public void nodeOperation1() {
        System.out.println(super.getNodeName() + " -->node operation1");
    }

    /**
     * 叶结点不需要递归
     */
    @Override
    public void nodeOperation2() {
        System.out.println(super.getNodeName() + " -->node operation2");
    }

}
