package package1;

public class Main {

    public static void main(String[] args) {


        int tab[] = {45, 21, 67, 90, 4, 50};
        int deadl[] = {7 , 12, 3, 67, 5, 1};
        int head = 50;

        FCFS fcfs = new FCFS(head,tab);
        fcfs.execute();
        fcfs.result();

        SSTF sstf = new SSTF();
        sstf.write(head, tab);
        sstf.execute();
        sstf.result();

        SCAN scan = new SCAN();
        scan.write(head, tab);
        scan.execute();
        scan.result();

        CSCAN cscan = new CSCAN();
        cscan.write(head, tab);
        cscan.execute();
        cscan.result();

        EDF edf = new EDF();
        edf.write(head, tab, deadl);
        edf.execute();
        edf.result();

        FDSCAN fdscan = new FDSCAN();
        fdscan.write(head, tab, deadl);
        fdscan.execute();
        fdscan.result();
    }
}
