package leetcode.UnionFind;

/**
 * leetcode
 * 2020/9/17 11:25
 * 冗余连接
 *
 * @author Chan
 * @since
 **/
public class Hard_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodeNums = edges.length;
        //并查集
        int[] union = new int[nodeNums + 1];
        //记录父亲结点
        int[] parent = new int[nodeNums + 1];
        int confict = -1;
        int cycle = -1;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            //初始化并查集
            if (union[u] == 0) {
                union[u] = u;
            }
            if (union[v] == 0) {
                union[v] = v;
            }

            //查看结点v是否已有父节点
            if (parent[v] == 0) {
                parent[v] = u;
                int uniU = find(u, union);
                int uniV = find(v, union);
                if (uniU != uniV) {
                    union[uniV] = uniU;
                } else { //遇到了环
                    cycle = i;
                }
            } else {
                //父节点冲突
                confict = i;
            }
        }

        if (confict < 0) { //没有冲突父节点，直接返回最后一个环边
            return edges[cycle];
        } else { //有冲突父节点
            int[] confictEdges = edges[confict];
            if (cycle >= 0) { //有环，返回没记录的冲突父边
                int[] res = {parent[confictEdges[1]], confictEdges[1]};
                return res;
            } else { // 没有环，返回冲突父边
                return confictEdges;
            }
        }
    }

    public int find(int node, int[] union) {
        if (union[node] == node) {
            return node;
        }
        union[node] = find(union[node], union);
        return union[node];
    }
}
