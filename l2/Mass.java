import java.util.Random;

public class Mass {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("none");
            return;
        }

        int n = Integer.parseInt(args[0]);
        Random rand = new Random();

        double[][][] array = new double[n][][];

        for (int i = 0; i < n; i++) {
            int rowLe = 1 + 2 * i;
            array[i] = new double[rowLe][];

            for (int j = 0; j < rowLe; j++) {
                int innerLe = i * i + j * j;

                array[i][j] = new double[innerLe];

                for (int k = 0; k < innerLe; k++) {
                    array[i][j][k] = rand.nextDouble();
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[" + i + "][" + j + "] ");

                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.printf("%.2f ", array[i][j][k]);
                }

                System.out.println();
            }

            System.out.println();
        }
    }
}
