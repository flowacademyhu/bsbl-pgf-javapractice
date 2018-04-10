import java.util.*;

public class Create {

    public double[][] arrayMaker() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            double[] array = new double[(int)arraySizes[x]];
            startTime = System.nanoTime();
            for(int i = 0; i < array.length; i++) {
                array[i] = random.nextInt()*101;
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] arrayListMaker() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            ArrayList arrayList = new ArrayList();
            startTime = System.nanoTime();
            for(int i = 0; i < arraySizes[x]; i++) {
                arrayList.add(random.nextInt()*101);
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] linkedListMaker() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            LinkedList linkedList = new LinkedList();
            startTime = System.nanoTime();
            for(int i = 0; i < arraySizes[x]; i++) {
                linkedList.add(random.nextInt()*101);
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] hashSetMaker() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            HashSet hashSet = new HashSet();
            startTime = System.nanoTime();
            for(int i = 0; i < arraySizes[x]; i++) {
                hashSet.add(random.nextInt()*101);
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] treeSetMaker() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            TreeSet treeSet = new TreeSet();
            startTime = System.nanoTime();
            for(int i = 0; i < arraySizes[x]; i++) {
                treeSet.add(random.nextInt()*101);
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }
}
