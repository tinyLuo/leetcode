package com.ly.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ly.ufs.UnionFindSet;

/**
 * 
 * 最小生成树 JAVA 实现，采用 Kruskal 算法
 * @author ly
 *
 */
public class MinSpanTree {
    // 邻接矩阵
    private int[][] matrix;
    
    private int size;
 
    public MinSpanTree(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }
    
    public boolean isConnected(int p, int q) {
        return matrix[p][q] > 0 ? true : false;
    }
    
    public void kruskal() {
        int[][] mst = new int[matrix.length][matrix[0].length];
        //将邻接矩阵按边的权重排序
        List<Edge> list = getEdges();
        Collections.sort(list);
        UnionFindSet unionFindSet = new UnionFindSet(size);
        for(Edge edge : list) {
            // 判断是否有环
            if(unionFindSet.isConnected(edge.getP(), edge.getQ())) {
                continue;
            }
            mst[edge.getP()][edge.getQ()] = edge.getWeight();
            unionFindSet.union(edge.getP(), edge.getQ());
        }
        this.matrix = mst;
    }
    
    public List<Edge> getEdges() {
        List<Edge> list = new ArrayList<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                Edge edge = new Edge(i, j, matrix[i][j]);
                list.add(edge);
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{2,3,0},{1,0,3},{0,1,2}};
        MinSpanTree minSpanTree = new MinSpanTree(matrix);
        minSpanTree.kruskal();
    }
    
    public static class Edge implements Comparable<Edge>{
        //点 p
        private int p;
        //点 q
        private int q;
        //权重
        private int weight;
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.getWeight();
        }
        
        public Edge(int p, int q, int weight) {
            super();
            this.p = p;
            this.q = q;
            this.weight = weight;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
        
    }
}
