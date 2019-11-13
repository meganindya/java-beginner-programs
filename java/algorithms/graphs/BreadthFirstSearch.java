/**
 * Breadth First Search
 *
 * Time  Complexity: O(V + E) where V is vertices and E is edges
 */


import java.util.*;

class BreadthFirstSearch {
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

        System.out.print("Breadth First Traversal starting from vertex 0: ");

        for (Integer i : g.BFS(0))
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


    // traverses graph using BFS from a given source vertex
    LinkedList<Integer> BFS(int source) {
        boolean visited[] = new boolean[numVertices];
        LinkedList<Integer> list = new LinkedList<>();

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(Integer.valueOf(source));
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll().intValue();
            list.add(node);

            for (Integer temp : adj[node]) {
                if (!visited[temp.intValue()]) {
                    visited[temp.intValue()] = true;
                    queue.add(temp);
                }
            }
        }


        return list;
    }
}