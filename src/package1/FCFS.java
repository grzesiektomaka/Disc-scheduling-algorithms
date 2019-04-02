package package1;

public class FCFS {

    private int initial_head_position;
    private int request_sequence[];

    private int execution_time = 0;
    private int sec_length;

    public FCFS(int initial_head_position, int request_sequence[] ){

        this.initial_head_position = initial_head_position;
        this.request_sequence = request_sequence;
        sec_length = request_sequence.length;

    }

    public void execute(){

        int head_position = initial_head_position;

        for(int i = 0; i < sec_length; i++){

            if(head_position >= request_sequence[i]){

                execution_time = execution_time + (head_position - request_sequence[i]);
                head_position = request_sequence[i];

            }else {

                execution_time = execution_time + (request_sequence[i] - head_position);
                head_position = request_sequence[i];

            }

        }
    }

    public void result(){

        System.out.print("FCFS:   " + execution_time + "    Sequence: ");

        for(int i = 0; i < sec_length; i++ ){

            System.out.print(request_sequence[i] + "  ");
        }

        System.out.println("");

    }
}
