package com.march;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class Mar23 {
    public int makeConnected(int n, int[][] connections) {
        // To connect n nodes, we need at least n - 1 edges
        if (connections.length < n - 1)
            return -1;

        int numOfConnected = 0;
        List<Integer>[] graph = new List[n];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
        }

        for (int i = 0; i < n; ++i)
            if (seen.add(i)) {
                dfs(graph, i, seen);
                ++numOfConnected;
            }

        return numOfConnected - 1;
    }

    private void dfs(List<Integer>[] graph, int u, Set<Integer> seen) {
        for (final int v : graph[u])
            if (seen.add(v))
                dfs(graph, v, seen);
    }
}
