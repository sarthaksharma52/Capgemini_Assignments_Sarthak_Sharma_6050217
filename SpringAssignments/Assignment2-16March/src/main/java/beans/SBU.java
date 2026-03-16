package beans;

public class SBU {

    private int sbuId;
    private String sbuName;
    private String sbuHead;

    public void setSbuId(int sbuId) {
        this.sbuId = sbuId;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public String getSBUDetails() {

        return "SBU Details\n"
                + "SBU Id : " + sbuId
                + "\nSBU Name : " + sbuName
                + "\nSBU Head : " + sbuHead;
    }
}