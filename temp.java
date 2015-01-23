
noip  内还有关联一个百度文库讲解
http://quartergeek.com/noip2005-senior-solution/


package huawei;

import java.util.*;

public final class Demo
{
    
    
    //保存路径的栈
    //private Stack<Point> stack = new Stack<Point>();
    
    public Demo()
    {
        
    }

    private int m;
    private int n;
    private int[][] visitedMaz;
    private Point s = null;
    private Point p = null;
    private Stack<Point> currentStack = new Stack<Point>();
    private Map<Integer,Stack> map = new HashMap<Integer,Stack>();

    private int dealOneNode(Queue<Point> queue, Point e) {
        int ret = -1;
        for (Point c : getNextPostions(e)) {
            if (c.equals(this.p)) {
                currentStack.add(e);
                currentStack.add(c);
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

    private List<Point> getNextPostions(Point e)
    {
        int i = e.getX();
        int j = e.getY();
        List<Point> nearList = new LinkedList<Point>();
        addOneNode(i + 1, j, nearList, e);
        addOneNode(i, j + 1, nearList, e);
        addOneNode(i - 1, j, nearList, e);
        addOneNode(i, j - 1, nearList, e);
        return nearList;
    }

    private void addOneNode(int i, int j, List<Point> lst, Point e)
    {
        if (i >= m || i < 0 || j >= n || j < 0)
        {
            return;
        }

        int v = visitedMaz[i][j];
        if (v==0) {
//            System.out.println(i+" "+j+":"+e.steps);
            lst.add(new Point(i,j));
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
        Point out = new Point(maze.length - 1, maze[0].length - 1); //出口
        Point in = new Point(0, 0); //入口

        this.s = in;
        this.p = out;

        this.m = maze.length;
        this.n = maze[0].length;
        this.visitedMaz = maze;


        visitedMaz[s.getX()][s.getY()]=1;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(s);

        Node pre = new Node();
        while (!queue.isEmpty()) {

            Point e = queue.poll();
            int ret = dealOneNode(queue, e);
            if (ret>=0) {

                node = new Node();
                node.parent = e;
                if (ret==1){
                    break;
                }
            }
        }


        return currentStack;
    }

    class Node{
        Node parent;
        Point value;
    }


}
