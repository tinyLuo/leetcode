package com.ly.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Case133 {
    
    public static Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }
    
    public static Node clone(Node node, Map<Node, Node> map) {
        if(node == null) {
            return null;
        }
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        map.put(node, cloneNode);
        
        List<Node> cloneChilds = new ArrayList<>();
        List<Node> childs = node.neighbors;
        if(childs != null) {
            for(Node child : childs) {
                if(map.containsKey(child)) {
                    cloneChilds.add(map.get(child));
                }else {
                    Node cloneChild = clone(child, map);
                    cloneChilds.add(cloneChild);
                }
            }
            cloneNode.neighbors = cloneChilds;
        }
        return cloneNode;
    }
    
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node [val=" + val + ", neighbors=" + neighbors + "]";
        }
    };
    
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        
        Node node2 = new Node();
        node2.val = 2;
        
        Node node3 = new Node();
        node3.val = 3;
        
        Node node4 = new Node();
        node4.val = 4;
        
        List<Node> node1Nei = new ArrayList<>();
        node1Nei.add(node2);
        node1Nei.add(node4);
        node1.neighbors = node1Nei;
        
        List<Node> node2Nei = new ArrayList<>();
        node2Nei.add(node1);
        node2Nei.add(node3);
        node2.neighbors = node2Nei;
        
        List<Node> node3Nei = new ArrayList<>();
        node3Nei.add(node2);
        node3Nei.add(node4);
        node3.neighbors = node3Nei;
        
        List<Node> node4Nei = new ArrayList<>();
        node4Nei.add(node1);
        node4Nei.add(node3);
        node4.neighbors = node4Nei;
        
        Node clNode = cloneGraph(node1);
        System.out.println("Case133.main()");
    }
}
