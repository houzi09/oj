
noip  内还有关联一个百度文库讲解
http://quartergeek.com/noip2005-senior-solution/


package huawei;

import java.util.*;

public final class Demo
{
    
    
    public Demo()
    {
        
    }

    

    class Point{
        private int x;

        Point(int m, int n){
            x=m;
            y=n;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public boolean equals(Point v) {
            if (x==v.getX() && y==v.getY()) {
                return true;
            }
            return false;
        }

        private int y;


    }


    class LinkPoint extends Point
    {
        LinkPoint(int x, int y, LinkPoint p){
            super(x,y);
            pre = p;
        }

        public LinkPoint pre;
    }



    private int m;
    private int n;
    private int[][] visitedMaz;
    private LinkPoint s = null;
    private LinkPoint p = null;

    private Map<Integer,Stack> map = new HashMap<Integer,Stack>();

    private int dealOneNode(Queue<LinkPoint> queue, LinkPoint e) {
        int ret = -1;
        for (LinkPoint c : getNextPostions(e)) {
            if (c.equals(this.p)) {
                ret = 1;
            }
            else if(visitedMaz[c.getX()][c.getY()]==0) {
                visitedMaz[c.getX()][c.getY()]=1;
                queue.add(c);
                ret =0;
            }
        }

        return ret;
    }

    private List<LinkPoint> getNextPostions(LinkPoint e)
    {
        int i = e.getX();
        int j = e.getY();
        List<LinkPoint> nearList = new LinkedList<LinkPoint>();
        addOneNode(i + 1, j, nearList, e);
        addOneNode(i, j + 1, nearList, e);
        addOneNode(i - 1, j, nearList, e);
        addOneNode(i, j - 1, nearList, e);
        return nearList;
    }

    private void addOneNode(int i, int j, List<LinkPoint> lst, LinkPoint e)
    {
        if (i >= m || i < 0 || j >= n || j < 0)
        {
            return;
        }

        int v = visitedMaz[i][j];
        if (v==0) {
            lst.add(new LinkPoint(i,j,e));
        }

    }


    /*
      功能:从一个迷宫走出的最短路徑

      输入:
          一个N*M的数组,int[][] maze迷宫图作为输入，如
          {0, 1, 0, 0, 0},
          {0, 1, 0, 1, 0},
          {0, 0, 0, 0, 0},
          {0, 1, 1, 1, 0},
          {0, 0, 0, 1, 0}};

      输出:从左上角到右下角的最短路线：(0, 0)(1, 0)(2, 0)(2, 1)(2, 2)(2, 3)(2, 4)(3, 4)(4, 4)

    */
    public Stack<Point> go(int[][] maze)
    {
        //保存路径的栈
        Stack<Point> stack = new Stack<Point>();

        Point out = new Point(maze.length - 1, maze[0].length - 1); //出口
        Point in = new Point(0, 0); //入口

        this.s = new LinkPoint(in.getX(),in.getX(),null);
        this.p = new LinkPoint(out.getX(), out.getY(), null);

        this.m = maze.length;
        this.n = maze[0].length;
        this.visitedMaz = maze;


        visitedMaz[s.getX()][s.getY()]=1;
        Queue<LinkPoint> queue = new LinkedList<LinkPoint>();
        queue.add(s);


        while (!queue.isEmpty()) {

            LinkPoint e = queue.poll();
            int ret = dealOneNode(queue, e);

            if (ret==1){
                this.p.pre = e;
                stack.add((Point)p);
                break;
            }

        }

        LinkPoint it = this.p.pre;
        while (it!=null) {
            stack.add((Point)it);
            it = it.pre;
        }

        return stack;
    }

    public static void main(String[] args){    
            int[][] map={
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0}};

        MyTest tt = new MyTest();

        Stack<Point> st = tt.go(map);
        while(!st.empty()){
            Point p = st.pop();
            System.out.println(p.getX()+" "+p.getY());
        }
    }

}
