package me.weix.demo.designmodel.composite;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 非叶节点
 * @author weix
 * @date 2018/12/4 15:08
 */
public class CommenNode extends Node {

    private List<Node> nodes = Lists.newArrayList();

    public CommenNode(String nodeName) {
        super(nodeName);
    }

    /**
     * 非叶结点需要递归
     */
    @Override
    public void nodeOperation1() {
        System.out.println(super.getNodeName() + " -->node operation1");
        for(Node node : nodes) {
            node.nodeOperation1();
        }
    }

    @Override
    public void nodeOperation2() {
        System.out.println(super.getNodeName() + " -->node operation2");
        for(Node node : nodes) {
            node.nodeOperation1();
        }
    }

    @Override
    public void multyAdd(List<Node> nodes) {
        this.nodes.addAll(nodes);
    }

    @Override
    public void add(Node node) {
        this.nodes.add(node);
    }

    @Override
    public void remove(Node node) {
        this.nodes.remove(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
