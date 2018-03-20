import java.io.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.readFile("/home/papp/java_projects/FileIO/src/file.txt"));
        main.writeContentToFile("yolo.txt", "yolo, kismacska, lol");
        main.copyFile("/home/papp/java_projects/FileIO/src/file.txt", "output.txt");
        main.copyFile2("/home/papp/java_projects/FileIO/src/file.txt", "output2.txt");
    }

    public String readFile(String fileName) {
        StringBuilder results = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                results.append(line).append("\n");
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
        return results.toString();
    }

    public void writeContentToFile(String fileName, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new java.io.File(fileName), true));
            writer.write(content);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String from, String to) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(from));
            writer = new BufferedWriter(new FileWriter(to));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile2(String from, String to) {
        writeContentToFile(to, readFile(from));
    }
}
