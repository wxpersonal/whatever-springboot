package me.weix.demo.designmodel.composite;

import java.util.List;

/**
 * 树节点
 * @author weix
 * @date 2018/12/4 15:06
 */
public abstract class Node {

    private String nodeName;

    public Node(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * 结点操作1（叶子结点和非叶结点  需要递归）
     */
    public abstract void nodeOperation1();

    /**
     * 结点操作2（叶子结点和非叶结点 需要递归）
     */
    public abstract void nodeOperation2();

    public void multyAdd(List<Node> nodes) {
        //do nothing
    }

    public void add(Node node) {
        //do nothing
    }

    public void remove(Node node) {
        //do nothing
    }



    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
