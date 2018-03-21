import exception.BadQuality;

import java.io.*;
import java.util.ArrayList;

public class Inventory {

    static ArrayList<DairyProduct> dairyList = new ArrayList<>();
    static ArrayList<Fruit> fruitList = new ArrayList<>();
    static ArrayList<Object> expired = new ArrayList<>();
    static ArrayList<Object> good = new ArrayList<>();

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.processFile("input.csv");
        try {
            inventory.parseListDairy(dairyList);
            inventory.parseListFruit(fruitList);
        } catch (BadQuality b) {
            b.printStackTrace();
        }


    }

    public void processFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.startsWith("D")) {
                    String[] dairyArray = line.split(";");
                    DairyProduct dp = new DairyProduct(dairyArray[3], Long.parseLong(dairyArray[2]), Long.parseLong(dairyArray[1]));
                    dairyList.add(dp);
                } else if (line.startsWith("F")) {
                    String[] fruitArray = line.split(";");
                    Fruit fruit = new Fruit(fruitArray[1]);
                    fruitList.add(fruit);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void parseListDairy(ArrayList<DairyProduct> list) throws BadQuality {
        BufferedWriter writeGood = null;
        BufferedWriter writeExpired = null;
        try {
            writeGood = new BufferedWriter(new FileWriter("shelf.txt", true));
            writeExpired = new BufferedWriter(new FileWriter("trash.txt", true));
            for (int i = 0; i < list.size(); i++) {
                try {
                    if(list.get(i).stillGood()) {
                        writeGood.write(list.get(i).toString() + "\n");
                    }
                } catch (BadQuality b) {
                    writeExpired.write((list.get(i).toString()) + "\n");
                    b.printStackTrace();
                }

            }
            writeGood.flush();
            writeExpired.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeGood.close();
                writeExpired.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void parseListFruit(ArrayList<Fruit> list) throws BadQuality {
        BufferedWriter writeGood = null;
        BufferedWriter writeExpired = null;
        try {
            writeGood = new BufferedWriter(new FileWriter("shelf.txt", true));
            writeExpired = new BufferedWriter(new FileWriter("trash.txt", true));
            for (int i = 0; i < list.size(); i++) {
                try {
                    if(list.get(i).stillGood()) {
                        writeGood.write(list.get(i).toString() + "\n");
                    } else {
                        writeExpired.write(list.get(i).toString() + "\n");
                    }
                } catch (BadQuality b) {
                    writeExpired.write(list.get(i).toString() + "\n");
                }
            }
            writeGood.flush();
            writeExpired.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeGood.close();
                writeExpired.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
