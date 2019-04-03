package package1;

public class SCAN {

    private int initial_head_position;
    private int result_sequence[];
    SequenceElement elements[];

    private int execution_time = 0;
    private int sec_length = 0;


    public void write(int initial_head_position, int request_sequence[]) {

        this.initial_head_position = initial_head_position;
        sec_length = request_sequence.length;

        //sort array------------------------------------

        int temp = 0;

        for (int i = 0; i < request_sequence.length ; ++i) {

            for (int j = i + 1; j < request_sequence.length; ++j) {

                if (request_sequence[i] > request_sequence[j]) {

                    temp =  request_sequence[i];
                    request_sequence[i] = 	request_sequence[j];
                   request_sequence[j] = temp;
                }
            }
        }

        //-----------------------------------------------

        result_sequence = new int[request_sequence.length];

        elements = new SequenceElement[request_sequence.length];


        for (int i = 0; i < request_sequence.length; i++) {

            elements[i] = new SequenceElement();
            elements[i].setPosition(request_sequence[i]);

        }
    }

    public void execute ()
    {
        int head_position = initial_head_position;
        int middle_index = 0;
        int j = 0;

        for (int i = 0; i < sec_length; i++){

            if(elements[i].getPosition() > head_position)
                break;

            middle_index = i;
        }

        for(int i = middle_index; i >= 0; i--){

            execution_time = execution_time + Math.abs(head_position - elements[i].getPosition());
            head_position = elements[i].getPosition();
            result_sequence[j] = elements[i].getPosition();
            j++;
        }

        for(int i = middle_index + 1; i < sec_length; i++){

            execution_time = execution_time + Math.abs(head_position - elements[i].getPosition());
            head_position = elements[i].getPosition();
            result_sequence[j] = elements[i].getPosition();
            j++;
        }



    }

    public void result() {

        System.out.print("SCAN:   " + execution_time + "    Sequence: ");

        for (int i = 0; i < sec_length; i++) {

            System.out.print(result_sequence[i] + "  ");
        }

        System.out.println("");

    }
}

