package com.ly.ufs;


/**
 * 
 * 并查集的 JAVA 实现
 * @author ly
 *
 */
public class UnionFindSet {
    
    private int[] group;
    
    private int size;
    
    public UnionFindSet(int size) {
        if(size <= 0) {
            return ;
        }
        this.size = size;
        group = new int[this.size];
        //每个点的 group 都默认为自己
        for(int i = 0 ; i < size ; i++) {
            group[i] = i;
        }
    }
    
    public int find(int p) {
        int point = p;
        int g = -1;
        while((g = group[point]) != point) {
            point = g;
        }
        group[p] = g;
        return g;
    }
    
    public boolean isConnected(int p, int q) {
        return group[p] == group[q];
    }
    
    public void union(int p, int q) {
        int gp = find(p);
        int gq = find(q);
        if(gp == gq) {
            return;
        }
        //大的 group 合并到小的
        if(gp > gq) {
            group[p] = q;
        }else {
            group[q] = p;
        }
    }
    
    public int[] getGroup() {
        return group;
    }
    
    public static void main(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(10);
        unionFindSet.union(4, 3);
        unionFindSet.union(3, 8);
        unionFindSet.union(6, 5);
        unionFindSet.union(9, 4);
        unionFindSet.union(2, 1);
        unionFindSet.union(8, 9);
        unionFindSet.union(5, 0);
        unionFindSet.union(7, 2);
        unionFindSet.union(6, 1);
        unionFindSet.union(6, 7);
        
        System.out.println(unionFindSet.isConnected(3, 6));
        System.out.println(unionFindSet.isConnected(9, 0));
        
        System.out.println(unionFindSet.getGroup());
    }
}
