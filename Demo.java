//http://codefine.co/%E5%B9%BF%E5%BA%A6%E4%BC%98%E5%85%88%E7%AE%97%E6%B3%95%E8%A7%A3%E5%86%B3%E8%90%A5%E6%95%91%E5%85%AC%E4%B8%BB%E9%97%AE%E9%A2%98/


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Demo
{
    private int m;
    private int n;
    private char[][] visited;
    private Position s = null;
    private Position p = null;


    public static void main(String[] args) {
        char maze[][] = {
	{'.','.','.','.'},
	{'.','.','.','.'},
	{'.','.','.','.'},
	{'S','*','*','P'}
    };
    
     new Demo().saved(maze, 4, 4, 10);
    }

   

  public boolean saved(char[][] vis, int m, int n, int t) {
        if (t < 0) {
            return false;
        }

        this.m = m;
        this.n = n;
        this.visited = vis;

        init(m, n);

      if (s == null || p == null) {
            System.out.println("input visited error!");
            return false;
        }

        Queue<Position> queue = new LinkedList<Position>();
        queue.add(s);

	int steps = 0;
      while (!queue.isEmpty()) {
            Position e = queue.poll();
            steps = dealOneNode(queue, e);
		if (steps>0)
			break;
        }
       
   	if (steps <= t) {
            System.out.println("Saved the princess in " + steps + " seconds!");
            return true;
        }

        System.out.println("failed saved the princess! " + steps + " > " + t);
        return false;
    }

    private void init(int m, int n)
    {
        for (int i = 0; i != m; i++)
        {
            for (int j = 0; j != n; j++)
            {
                System.out.print(visited[i][j]);
                System.out.print(' ');                
                switch (visited[i][j])
                {
                case '*':
                    break;
                case 'S':
                    this.s = new Position(i, j, 'S');
                    break;
                case '.':
                    break;
                case 'P':
                    this.p = new Position(i, j, 'P');
                    break;
                default:
                    System.out.println("input visited error!");
                    System.exit(-1);
                }
            }
            System.out.println("");
        }
    }

    private int dealOneNode(Queue<Position> queue, Position e) {
      for (Position c : getNextPostions(e)) {
      	switch (c.mark) {
            case 'P':
                queue.clear();
		     return e.steps;
            case '.':
                visited[c.row][c.col] = '#';
                queue.add(c);
                break;
            default:
                System.err.println("some error!");
                System.exit(-1);
                break;
            }
        }
	return 0;
    }

    private List<Position> getNextPostions(Position e)
    {
        int i = e.row;
        int j = e.col;
        List<Position> nearList = new LinkedList<Position>();
        addOneNode(i + 1, j, nearList, e);
        addOneNode(i, j + 1, nearList, e);
        addOneNode(i - 1, j, nearList, e);
        addOneNode(i, j - 1, nearList, e);
        return nearList;
    }

    private void addOneNode(int i, int j, List<Position> lst, Position e)
    {
        if (i >= m || i < 0 || j >= n || j < 0)
        {
            return;
        }

        char v = visited[i][j];
        switch (v)
        {
        case '.':
        case 'P':
		Position p = new Position(i, j, v);
		System.out.println(i+" "+j+":"+e.steps);
		p.steps = 1+e.steps;
            lst.add(p);
            break;
        default:
            break;
        }
    }

    private class Position
    {
        public int row;
        public int col;
        public char mark;
        public int steps=1;

        public Position(int i, int j, char value)
        {
            this.row = i;
            this.col = j;
            this.mark = value;
        }
    }
}
