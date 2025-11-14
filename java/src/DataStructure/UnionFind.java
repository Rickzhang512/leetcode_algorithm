package DataStructure;

public class UnionFind {
    private int count;  //连通分量数
    private int[] parent;//存储每个节点的父节点
    private int[] size;//记录每棵树的“重量” 点所在集合的大小

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];

        for(int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.size[i] = 1;
        }

    }

    //
    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ) {
          return;
        }
        //大树接小树下面
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count--;
    }

    //判断是否连通
    public boolean isConnected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    public int find(int x) {
        //路径压缩
        while(parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public int count() {
        return this.count;
    }


    public int size(int x) {
        return size[this.find(x)];
    }
}
