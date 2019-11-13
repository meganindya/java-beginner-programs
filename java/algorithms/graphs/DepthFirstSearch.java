/**
 * Depth First Search
 *
 * Time  Complexity: O(V + E) where V is vertices and E is edges
 */


import java.util.*;

class DepthFirstSearch {
    public static void main(String args[]) {
        DirGraph g = new DirGraph(5);

        /*
            0 — 1 — 3
            | / | /
            2 — 4
        */

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        System.out.print("Depth First Traversal starting from vertex 0: ");

        LinkedList<Integer> nodes = g.DFS(0);
        for (Integer i : nodes)
            System.out.print(i.intValue() + " ");
        System.out.println();
    }
}


// directed graph class
class DirGraph {
    private int numVertices;
    private LinkedList<Integer> adj[];  // adjacency list

    // parameterized constructor
    @SuppressWarnings("unchecked")
    DirGraph(int v) {
        numVertices = v;
        adj = new LinkedList[v];
        
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }


    // adds an edge into the graph
    void addEdge(int start, int end) {
        adj[start].add(end);
    }


    // traverses graph using DFS from a given source vertex
    LinkedList<Integer> DFS(int source) {
        boolean visited[] = new boolean[numVertices];
        LinkedList<Integer> list = new LinkedList<>();

        list.add(source);
        DFS(source, visited, list);
        
        return list;
    }

    // utility function for DFS
    void DFS(int source, boolean visited[], LinkedList<Integer> list) {
        for (Integer node : adj[source]) {
            if (visited[node.intValue()])
                continue;
            
            list.add(node);
            visited[node.intValue()] = true;

            DFS(node.intValue(), visited, list);
        }
    }
}