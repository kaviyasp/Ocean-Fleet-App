import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.print("Enter number of vessels: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(":");
            Vessel v = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );
            util.addVesselPerformance(v);
        }

        System.out.print("Enter vesselId to search: ");
        String id = sc.nextLine();
        Vessel found = util.getVesselById(id);

        if (found != null) {
            System.out.println(found.getVesselName());
        } else {
            System.out.println("No Vessel Found");
        }

        List<Vessel> highPerf = util.getHighPerformanceVessels();
        for (Vessel v : highPerf) {
            System.out.println(v.getVesselName());
        }
    }
}
