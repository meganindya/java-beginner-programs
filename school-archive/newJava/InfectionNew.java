class InfectionNew {
    class TreeNode {
        int  data;
        TreeNode lc, rc;
        TreeNode(int data) {
            this.data = data;
            lc = rc = null;
        }
    }

    private static TreeNode root, inf;
    private static int maxTime;
    public static void main(String args[]) {
        InfectionNew ob = new InfectionNew();
        
        ob.createTree();
        ob.findMaxTime();

        System.out.println("Required Time: " + maxTime);
    }

    void createTree() {
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
        
        inf = root.rc.lc;         // 11
        //inf = root.rc.rc.rc;      // 13
        //inf = root.lc.lc;         // 3
        //inf = root.lc.rc.rc.lc;   // 8
        //inf = root.lc.rc.lc.lc;   // 6
        //inf = root.lc.rc.rc.rc;   // 9
    }

    class Height {
        int h;
    }

    class Previous {
        char p;
        Previous(char p) {
            this.p = p;
        }
    }

    void findMaxTime() {
        findMaxTime(root, new Height(), new Height(), new Previous('x'));
    }

    boolean findMaxTime(TreeNode root, Height lheight, Height rheight, Previous previous) {
        if(root == null) {
            lheight.h = -1;
            rheight.h = -1;
            return false;
        }

        if(root == inf) {
            lheight.h = 0;
            rheight.h = 0;
            previous.p = 'i';
            //System.out.println(root.data + "\t" + lheight.h + "\t" + rheight.h + "\t" + previous.p + "\t" + maxTime + "\t" + true);
            return true;
        }

        Height lhl = new Height(), rhl = new Height();
        Height lhr = new Height(), rhr = new Height();
        Previous pl = new Previous('x'), pr = new Previous('x');

        boolean leftContains  = findMaxTime(root.lc, lhl, rhl, pl);
        boolean rightContains = findMaxTime(root.rc, lhr, rhr, pr);

        if(leftContains) {
            if      (pl.p == 'l' || pl.p == 'i')  lheight.h = lhl.h + 1;
            else if (pl.p == 'r' || pl.p == 'i')  lheight.h = rhl.h + 1;
            previous.p = 'l';
            rheight.h = Math.max(lhr.h, rhr.h) + 1;
            maxTime = Math.max(maxTime, lheight.h + rheight.h);
            //System.out.println(root.data + "\t" + lheight.h + "\t" + rheight.h + "\t" + pr.p + "\t" + maxTime + "\t" + true);
            return true;
        }
        else if(rightContains) {
            if      (pr.p == 'l' || pr.p == 'i')  rheight.h = lhr.h + 1;
            else if (pr.p == 'r' || pr.p == 'i')  rheight.h = rhr.h + 1;
            previous.p = 'r';
            lheight.h = Math.max(lhl.h, rhl.h) + 1;
            maxTime = Math.max(maxTime, lheight.h + rheight.h);
            //System.out.println(root.data + "\t" + lheight.h + "\t" + rheight.h + "\t" + pr.p + "\t" + maxTime + "\t" + true);
            return true;
        }

        lheight.h = Math.max(lhl.h, rhl.h) + 1;
        rheight.h = Math.max(lhr.h, rhr.h) + 1;
        //System.out.println(root.data + "\t" + lheight.h + "\t" + rheight.h + "\t" + previous.p + "\t" + maxTime + "\t" + false);
        return false;
    }
}