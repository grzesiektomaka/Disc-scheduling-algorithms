package package1;

public class SequenceElement {

    private int position = 0;
    private boolean used_info = false;

    private int deadline = 0;

    public int getPosition() {

        return position;
    }

    public boolean getUsedInfo() {

        return used_info;
    }

    public int getDeadline(){

        return deadline;
    }

    public void setPosition(int position) {

        this.position = position;
    }

    public void setUsedInfo(boolean used_info){

        this.used_info = used_info;
    }

    public void setDeadline(int deadline){

        this.deadline = deadline;
    }
}
