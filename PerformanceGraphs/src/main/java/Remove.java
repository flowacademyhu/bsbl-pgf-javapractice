import java.util.*;

public class Remove {

    public double[][] arrayRemove() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            double[] array = new double[(int)arraySizes[x]];
            for(int i = 0; i < array.length; i++) {
                array[i] = random.nextInt()*101;
            }
            startTime = System.nanoTime();
            array[array.length - 1] = 0;
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] arrayListRemove() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            ArrayList arrayList = new ArrayList();
            for(int i = 0; i < arraySizes[x]; i++) {
                arrayList.add(random.nextInt()*101);
            }
            startTime = System.nanoTime();
            arrayList.remove(arrayList.size() - 1);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] linkedListRemove() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            LinkedList linkedList = new LinkedList();
            for(int i = 0; i < arraySizes[x]; i++) {
                linkedList.add(random.nextInt()*101);
            }
            startTime = System.nanoTime();
            linkedList.remove(linkedList.size() - 1);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] hashSetRemove(int value) {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            HashSet hashSet = new HashSet();
            for(int i = 0; i < arraySizes[x] - 1; i++) {
                hashSet.add(random.nextInt()*101);
            }
            hashSet.add(value);
            startTime = System.nanoTime();
            hashSet.remove(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] treeSetRemove(int value) {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            TreeSet treeSet = new TreeSet();
            for(int i = 0; i < arraySizes[x] - 1; i++) {
                treeSet.add(random.nextInt()*101);
            }
            treeSet.add(value);
            startTime = System.nanoTime();
            treeSet.remove(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }
}
