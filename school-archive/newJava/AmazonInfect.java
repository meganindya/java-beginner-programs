import java.util.*;
public class AmazonInfect {
	
	public static void main (String [] args) {
		
		AmazonInfect obj = new AmazonInfect();
		
		TreeNode infected=obj.createTree();
		obj.parentRecord.put(obj.root.data,null);
		
		obj.findMaxTime(infected, 0);
		System.out.println(obj.max);
	}
	
	class TreeNode{
		
		int data;
		TreeNode lc, rc;
		
		TreeNode(int data){
			this.data=data;
		}
	}TreeNode root;
	
	Map<Integer, TreeNode> parentRecord= new TreeMap<Integer, TreeNode>();
	List<TreeNode> visited = new ArrayList<TreeNode>();
	int max=0;
	
	int max(int n, int m) {
		if(m>n)
			return m;
		return n;
	}
	TreeNode createTree() {
		
		root = new TreeNode(1);
        
        root.lc = new TreeNode(2);
        root.lc.lc = new TreeNode(3);
        root.lc.rc = new TreeNode(4);
        root.lc.rc.lc = new TreeNode(5);
        root.lc.rc.lc.lc = new TreeNode(6);
        root.lc.rc.rc = new TreeNode(7);
        root.lc.rc.rc.lc = new TreeNode(8);
        root.lc.rc.rc.rc = new TreeNode(9);
        
        root.rc = new TreeNode(10);
        root.rc.lc = new TreeNode(11);
        root.rc.rc = new TreeNode(12);
        root.rc.rc.rc = new TreeNode(13);
        
        TreeNode inf = root.rc.lc;
        recordsOfParents(root);
        
        return inf;
        
	}
	
	void recordsOfParents(TreeNode root) {
		
		if(root.lc!=null) {
			recordsOfParents(root.lc);
			parentRecord.put(root.lc.data,root);
		}
		if(root.rc!=null) {
			recordsOfParents(root.rc);
			parentRecord.put(root.rc.data,root);
		}
	}
	
	int heightOfTree(TreeNode root) {
		
		if(root==null)
			return 0;
		else {
			
			return (1+max(heightOfTree(root.lc),heightOfTree(root.rc)));
		}
		
	}
	
	void findMaxTime(TreeNode infected, int timeUp) {
		
		visited.add(infected);
		TreeNode nextNode;
		
		if(visited.contains(infected.lc))
			nextNode=infected.rc;
		else
			nextNode=infected.lc;
		
		if(nextNode!=null ) {
			int newTime = timeUp+heightOfTree(nextNode);
			max = max<newTime ? newTime:max;
		}
			
		if(parentRecord.get(infected.data)!=null) {
			findMaxTime(parentRecord.get(infected.data),timeUp+1);
		}
		
	}
}
