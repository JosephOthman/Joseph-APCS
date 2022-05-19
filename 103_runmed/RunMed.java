import java.net.SocketPermission;

public class RunMed {
    /**
     Algo:
     * 
     */
    private ALHeapMin beegVals;
    private ALHeapMax lilVals;

    public RunMed() {
        beegVals = new ALHeapMin();
        lilVals = new ALHeapMax();
    }

    public boolean add(Integer newVal) {
        
        if (beegVals.size() != 0 && newVal.compareTo(beegVals.peekMin()) > 0 ) {
            beegVals.add(newVal);
        } else if (lilVals.size() != 0 && newVal.compareTo(lilVals.peekMax()) < 0) {
            lilVals.add(newVal);
        }
        if(Math.abs(beegVals.size() - lilVals.size()) >= 2) {
            balance();
        }
        if(beegVals.size() == 0 && lilVals.size() == 0) {
            beegVals.add(newVal);
        }
        return true;
    }

    public boolean balance() {
        if (beegVals.size() > lilVals.size()) {
            lilVals.add(beegVals.removeMin());
        } else if (beegVals.size() < lilVals.size()) {
            beegVals.add(lilVals.removeMax());
        }
        return true;
    }

    public double getMedian() {
        if ((beegVals.size() + lilVals.size()) % 2 == 0) {
            return (double) (beegVals.peekMin() + lilVals.peekMax()) / 2;
        } else if (beegVals.size() > lilVals.size()) {
            return (double) beegVals.peekMin();
        } else {
            return (double) lilVals.peekMax();
        }
    }

    public String toString() { 
        String retStr = "lilVals:\n";
        retStr += lilVals.toString();
        retStr += "beegVals:\n";
        retStr += beegVals.toString();
        return retStr;
    }

    public static void main(String[] args) {
        RunMed rm = new RunMed();
        rm.add(1);
        rm.add(2);
        System.out.println(rm + "\n");
        System.out.println("Current median: " + rm.getMedian());
        rm.add(5);
        rm.add(10);
        System.out.println(rm + "\n");
        System.out.println("Current median: " + rm.getMedian());
    }
}
