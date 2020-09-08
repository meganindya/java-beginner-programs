import java.util.*;

class Infection {
    class TreeNode {
        TreeNode lc, rc;
    }
    
    public static void main(String args[]) {
        Infection obj = new Infection();
        obj.createTree();
    }
    
    void createTree() {
        TreeNode root = new TreeNode();
        
        root.lc = new TreeNode();
        root.lc.lc = new TreeNode();
        root.lc.rc = new TreeNode();
        root.lc.rc.lc = new TreeNode();
        root.lc.rc.lc.rc = new TreeNode();
        root.lc.rc.rc = new TreeNode();
        root.lc.rc.rc.lc = new TreeNode();
        root.lc.rc.rc.rc = new TreeNode();
        root.lc.rc.rc.rc.lc = new TreeNode();
        root.lc.rc.rc.rc.rc = new TreeNode();
        
        root.rc = new TreeNode();
        root.rc.rc = new TreeNode();
        root.rc.rc.lc = new TreeNode();
        root.rc.rc.rc = new TreeNode();
        root.rc.lc = new TreeNode();
        root.rc.lc.rc = new TreeNode();
        root.rc.lc.rc.rc = new TreeNode();
        root.rc.lc.rc.rc.rc = new TreeNode();
        root.rc.lc.rc.rc.rc.rc = new TreeNode();
        
        TreeNode inf = root.lc.rc.lc.rc;
        
        /*root.lc = new TreeNode();
        root.lc.lc = new TreeNode();
        root.lc.rc = new TreeNode();
        root.lc.rc.lc = new TreeNode();
        root.lc.rc.lc.lc = new TreeNode();
        root.lc.rc.rc = new TreeNode();
        root.lc.rc.rc.lc = new TreeNode();
        root.lc.rc.rc.rc = new TreeNode();
        
        root.rc = new TreeNode();
        root.rc.lc = new TreeNode();
        root.rc.rc = new TreeNode();
        root.rc.rc.rc = new TreeNode();
        
        TreeNode inf = root.lc.lc;*/
        
        int ans = new Infection().findMaxTime(root, inf);
        System.out.println("Time Required : " + ans);
    }
    
    int findMaxTime(TreeNode root, TreeNode inf) {
        Map<TreeNode, LinkedList<TreeNode>> graph = 
            new HashMap<TreeNode, LinkedList<TreeNode>>();
        
        class TreeOperations {
            void createUGraphPreOrder(TreeNode root) {
                if(root == null)    return;
                
                LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
                if(root.lc != null)     temp.add(root.lc);
                if(root.rc != null)     temp.add(root.rc);
                
                if(temp.size() > 0) {
                    if(graph.containsKey(root)) {
                        LinkedList<TreeNode> glist = graph.get(root);
                        glist.addAll(temp);
                        graph.put(root, glist);
                    }
                    else
                        graph.put(root, temp);
                }
                
                if(root.lc != null) {
                    LinkedList<TreeNode> tem = new LinkedList<TreeNode>();
                    tem.add(root);
                    graph.put(root.lc, tem);
                    createUGraphPreOrder(root.lc);    
                }
                if(root.rc != null) {
                    LinkedList<TreeNode> tem = new LinkedList<TreeNode>();
                    tem.add(root);
                    graph.put(root.rc, tem);
                    createUGraphPreOrder(root.rc);
                }
            }
            
            int findMaxTime(TreeNode root, TreeNode inf) {
                class NodeDistPair {
                    TreeNode node;
                    int dist;
                    NodeDistPair(TreeNode node, int dist) {
                        this.node = node;
                        this.dist = dist;
                    }
                }
                
                    //BFS
                Map<TreeNode, Boolean> visited =
                    new HashMap<TreeNode, Boolean>();
                Set<Map.Entry<TreeNode, LinkedList<TreeNode>>> s = graph.entrySet();
                for(Map.Entry<TreeNode, LinkedList<TreeNode>> m : s)
                    visited.put(m.getKey(), false);
                
                Queue<NodeDistPair> q = new ArrayDeque<NodeDistPair>();
                q.offer(new NodeDistPair(inf, 0));
                
                int maxtime = 0;
                while(!q.isEmpty()) {
                    NodeDistPair temp = q.poll();
                    visited.put(temp.node, true);
                    maxtime = Math.max(maxtime, temp.dist);
                    
                    LinkedList<TreeNode> ls = graph.get(temp.node);
                    for(TreeNode tnode : ls) {
                        if(!visited.get(tnode))     // child node not visited
                            q.offer(new NodeDistPair(tnode, temp.dist + 1));
                    }
                }
                return maxtime;
            }
        }
        
        TreeOperations ob = new TreeOperations();
        ob.createUGraphPreOrder(root);
        return ob.findMaxTime(root, inf);        // method of inner class; not itself
    }
}