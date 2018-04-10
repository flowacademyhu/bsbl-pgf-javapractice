import java.util.*;

public class Contains {

    public double[][] arrayContains() {
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
            int value = 300;
            //int value = random.nextInt()*101;
            startTime = System.nanoTime();
            for (int i = 0; i < array.length; i++) {
                if(array[i] == value) {
                    break;
                }
            }
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] arrayListContains() {
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
            int value = 300;
            //int value = random.nextInt()*101;
            startTime = System.nanoTime();
            arrayList.contains(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] linkedListContains() {
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
            int value = 300;
            //int value = random.nextInt()*101;
            startTime = System.nanoTime();
            linkedList.contains(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] hashSetContains() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            HashSet hashSet = new HashSet();
            for(int i = 0; i < arraySizes[x]; i++) {
                hashSet.add(random.nextInt()*101);
            }
            int value = 300;
            //int value = random.nextInt()*101;
            startTime = System.nanoTime();
            hashSet.contains(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }

    public double[][] treeSetContains() {
        long startTime;
        long endTime;
        double[][] chartArray = new double[8][8];
        double[] arraySizes = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
        double[] times = new double[8];
        Random random = new Random();
        for(int x = 0; x < arraySizes.length; x++) {
            TreeSet treeSet = new TreeSet();
            for(int i = 0; i < arraySizes[x]; i++) {
                treeSet.add(random.nextInt()*101);
            }
            int value = 300;
            //int value = random.nextInt()*101;
            startTime = System.nanoTime();
            treeSet.contains(value);
            endTime = System.nanoTime();
            times[x] = (endTime - startTime) / 1000000d;
        }
        return new double[][]{arraySizes, times};
    }
}
