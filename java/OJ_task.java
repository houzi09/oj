import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by seaf on 16-3-2.
 */
public class OJ_task {

    public static class Task{
        public int sum = 0;
        public List<Integer> list = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(8);
        a.add(7);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        int k = 3;
        Task[] tasks = new Task[k];
        int avg=0;
        for(int j:a){
            avg+=j;
        }
        avg/=k;


        for(int i=0;i<k;i++){
            tasks[i] = new Task();
            Task task = tasks[i];
            Iterator<Integer> it = a.iterator();
            while(it.hasNext()){
                int v = it.next();
                if (task.sum+v<= avg){
                    task.sum+=v;
                    task.list.add(v);
                    it.remove();
                } else if (task.sum>=avg){
                    break;
                }
            }
        }
        if(!a.isEmpty()){
            for(int j=k-1;j>=0;j--){
                Task task = tasks[j];
                Iterator<Integer> it = a.iterator();
                while(it.hasNext()){
                    int v = it.next();
                    if (task.sum< avg){
                        task.sum+=v;
                        task.list.add(v);
                        it.remove();
                    } else {
                        break;
                    }
                }
            }
        }

        for(Task task : tasks){
            System.out.print(task.sum + ":");
            for(int n:task.list) {
                System.out.print(" " + n);
            }
            System.out.println();
        }
        return;
    }

}
