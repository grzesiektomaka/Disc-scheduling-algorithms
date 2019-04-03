package package1;

public class FDSCAN {
    private int initial_head_position;
    private int result_sequence[];
    SequenceElement elements[];

    private int execution_time = 0;
    private int sec_length = 0;


    public void write(int initial_head_position, int request_sequence[], int deadline[]) {

        this.initial_head_position = initial_head_position;
        sec_length = request_sequence.length;

        //sort array------------------------------------

        int temp = 0;

        for (int i = 0; i < deadline.length ; ++i) {

            for (int j = i + 1; j < deadline.length; ++j) {

                if (deadline[i] > deadline[j]) {

                    temp =  request_sequence[i];
                    request_sequence[i] = 	request_sequence[j];
                    request_sequence[j] = temp;

                    temp = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = temp;


                }
            }


        }

        //-----------------------------------------------

        result_sequence = new int[request_sequence.length];

        elements = new SequenceElement[request_sequence.length];


        for (int i = 0; i < request_sequence.length; i++) {

            elements[i] = new SequenceElement();
            elements[i].setPosition(request_sequence[i]);
            elements[i].setDeadline(deadline[i]);

        }
    }

    public void execute ()
    {


        int head_position = initial_head_position;

        int j = 0;

        for (int i = 0; i < sec_length; i++){

            if(!elements[i].getUsedInfo()) {

                for(int k = 0; k < sec_length - 1; k++){


                        if ( elements[k].getUsedInfo() == false && elements[k].getPosition() > head_position && elements[k].getPosition() < elements[i].getPosition() && k != i) {

                            execution_time = execution_time + Math.abs(head_position - elements[k].getPosition());
                            head_position = elements[k].getPosition();
                            elements[k].setUsedInfo(true);
                            result_sequence[j] = elements[k].getPosition();
                            j++;
                        }


                }

                execution_time = execution_time + Math.abs(head_position - elements[i].getPosition());
                head_position = elements[i].getPosition();
                elements[i].setUsedInfo(true);
                result_sequence[j] = elements[i].getPosition();
                j++;


            }


        }

    }

    public void result() {

        System.out.print("FDSCAN: " + execution_time + "    Sequence: ");

        for (int i = 0; i < sec_length; i++) {

            System.out.print(result_sequence[i] + "  ");
        }

        System.out.println("");

    }
}
