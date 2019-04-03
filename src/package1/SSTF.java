package package1;

public class SSTF {

    private int initial_head_position;
    private int result_sequence[];
    SequenceElement elements[];

    private int execution_time = 0;
    private int sec_length = 0;

    public void write(int initial_head_position, int request_sequence[]) {

        this.initial_head_position = initial_head_position;
        sec_length = request_sequence.length;

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
            int minimum;
            int temp_length = 0;
            int index = 0;
            int res = 0;

            for (int i = 0; i < sec_length; i++) {

                minimum = Integer.MAX_VALUE;

                for (int j = 0; j < sec_length; j++) {

                    if (!elements[j].getUsedInfo()) {

                        temp_length = Math.abs(head_position - elements[j].getPosition());


                        if (temp_length < minimum) {

                            minimum = temp_length;
                            index = j;


                        }

                    }

                }
                
                execution_time = execution_time + minimum;
                head_position = elements[index].getPosition();
                elements[index].setUsedInfo(true);
                result_sequence[i] = elements[index].getPosition();

            }

        }

        public void result() {

            System.out.print("SSTF:   " + execution_time + "    Sequence: ");

            for (int i = 0; i < sec_length; i++) {

                System.out.print(result_sequence[i] + "  ");
            }

            System.out.println("");

        }
    }

