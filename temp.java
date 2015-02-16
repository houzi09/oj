

推荐：(IBM mahout文档)
http://www.zhihu.com/question/20558659

协同过滤:
http://www.zhihu.com/question/22404652

Pearson：
http://blog.csdn.net/database_zbye/article/details/8664516
pearson correlation 缺点 (G)


小教官
http://blog.tomtung.com/2007/10/noip05-fire/

菱形距离
http://blog.csdn.net/nys001/article/details/12637201




性能调优工具 Flame Graph：
http://structureddata.org/2012/06/18/linux-6-transparent-huge-pages-and-hadoop-workloads/


大话数据挖掘
http://blog.sina.com.cn/s/blog_6255c70101019ks3.html

单词博弈：
http://www.cnblogs.com/TenosDoIt/p/3485090.html

青蛙过河
http://blog.tomtung.com/2007/09/noip05-river/
http://blog.csdn.net/u013491262/article/details/20783747  非递归





大M法：对于 >=0的：
http://blog.csdn.net/se511/article/details/9042027



单纯形解的标准形是 变量的约束都大于等于0，参数式都等于0.

初始基变量是有单位的
选所有非基变量其中的校验数最大的，然后用参数式的b去除，最小的值所处的行对应的基变量（即为1）排除出基变量，然后对当前列做初等行变换（校验数的行也参与），变成单位列向量。


基变量（单位列向量）对应的检验数必须是0.
最优解的向量为最后基变量对应的b值。最优解为校验数的等式的b的相反数。因为b=-z


1.所有非基变量的校验数小于0，有唯一最优解。
2.小于等于0，存在等于0，有无穷多最优解。
3.存在大于0，而且所在的列均小于0，则有无解。
4.存在大于0，且所在的列存在大于0，进行基的转换。




public class Demo
{



	 /**
     * 
     * @param minmax              :求函数的最大值或最小值（1表示取最大值，-1表示取最小值）
     * @param restrictionNum      :约束条件的个数
     * @param variableNum         :变量个数
     * @param restrictionNumLess  :<=的约束条件个数
     * @param restrictionNumEqual :=的约束条件个数
     * @param restrictionNumMore  :>=的约束条件个数
     * @param a                   :约束条件的系数矩阵(按照条件<=,=,>=排列)
     * @param x                   :目标函数的价值系数
     */
    public Demo(double minmax, int restrictionNum, int variableNum,
            int restrictionNumLess, int restrictionNumEqual, int restrictionNumMore,
            double a[][], int x[])
    {




    }
    
    /**
     * 
     * 计算线性规划结果
     * @return  double[]长度为2，double[0]取值为0，1，2，3
     *          0表示有最优解（一个和多个均可）
     *          1表示参数错误（也就是条件个数之和与条件数组长度不符合）
     *          2表示无界解（也就是最优解为正无穷或负无穷）
     *          3表示无可行解（也就是条件冲突，任何一组数字都不可能满足所有条件）
     *          
     *          double[1]为最优化值，仅在double[0] == 0时有意义
     *          
     */
    public double[] solve()
    {
        double[] result = new double[2];

        return result;
    }
    
    
}





import huawei.Demo;

import junit.framework.TestCase;

public class DemoTest extends TestCase
{
    public void testCase00()
    {
        
        double a[][] = {{1,-2,1,11},{-2,0,1,1},{-4,1,2,3}};
        int x[] = {-3,1,1};
        
        Demo demo = new Demo(-1,3,3,1,1,1,a,x);
        double[] result = demo.solve();
        
        assertTrue((-0.01 < (0- result[0]) ) && ((0 - result[0]) < 0.01));
        
        assertTrue((-0.01 < (-2.0 - result[1]) ) && ((-2.0 - result[1]) < 0.01));
        
    }
    
    public void testCase01()
    {
        
        double a[][] = {{5,10,50},{0,1,4},{1,1,1}};
        int x[] = {1,3};
        Demo demo = new Demo(1,3,2,2,0,1,a,x);
        double[] result = demo.solve();
        
        assertTrue((-0.01 < (0- result[0]) ) && ((0 - result[0]) < 0.01));
        
        assertTrue((-0.01 < (14 - result[1]) ) && ((14 - result[1]) < 0.01));
        
    }
    
  
    
}








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
