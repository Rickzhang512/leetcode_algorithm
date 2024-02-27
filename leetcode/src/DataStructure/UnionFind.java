package DataStructure;

public class UnionFind {
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];

        for(int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.size[i] = 1;
        }

    }

    public void union(int p, int q) {
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP != rootQ) {
            int[] var10000;
            if (this.size[rootP] < this.size[rootQ]) {
                this.parent[rootP] = rootQ;
                var10000 = this.size;
                var10000[rootQ] += this.size[rootP];
            } else {
                this.parent[rootQ] = rootP;
                var10000 = this.size;
                var10000[rootP] += this.size[rootQ];
            }

        }
    }

    public boolean isConnected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    public int find(int x) {
        while(this.parent[x] != x) {
            this.parent[x] = this.parent[this.parent[x]];
            x = this.parent[x];
        }

        return x;
    }

    public int count() {
        return this.count;
    }
}
