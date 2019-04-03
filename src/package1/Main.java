package package1;

public class Main {

    public static void main(String[] args) {


        int tab[] = {45, 21, 67, 90, 4, 50};
        int head = 50;

        FCFS fcfs = new FCFS(head,tab);

        fcfs.execute();
        fcfs.result();

        SSTF sstf = new SSTF();
        sstf.write(head, tab);
        sstf.execute();
        sstf.result();
    }
}
