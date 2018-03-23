import java.io.*;
public class RentalMain {

    public static void main(String[] args) {
        /*
        Blockbuster bb = new Blockbuster();

        Video starWars = new Video("Star Wars", 12, "two-day");
        EducationalVideo planetEarth = new EducationalVideo("Planet Earth", "unlimited");

        System.out.println(starWars);
        System.out.println(planetEarth);

        bb.addVideo(starWars);
        bb.addVideo(planetEarth);

        try {
            System.out.println(bb.search("Star Wars", false));
            starWars.rent(18, 1);
            System.out.println(bb.search("Star Wars", false));
            planetEarth.rent(20, 1);
            System.out.println(planetEarth);
        } catch (NotFoundException n) {
            n.printStackTrace();
        } catch (RentingErrorException r) {
            r.printStackTrace();
        }
        */

        RentalMain rm = new RentalMain();
        rm.serializeBlockbuster(rm.rentVideos(rm.processFile("input.txt")));

    }

    public Blockbuster processFile(String filename) {
        BufferedReader br = null;
        Blockbuster blockBuster = new Blockbuster();
        try {
            String line;
            br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(";");
                if (tmp.length == 3) {
                    Video video = new Video(tmp[0], Integer.parseInt(tmp[2]), tmp[1]);
                    blockBuster.addVideo(video);

                } else if (tmp.length == 2) {
                    EducationalVideo educationalVideo = new EducationalVideo(tmp[0], tmp[1]);
                    blockBuster.addVideo(educationalVideo);
                } else {
                    throw new InvalidInput("The input.txt is wrongly written.");
                }
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (InvalidInput i) {
            i.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }

        return blockBuster;
    }

    public Blockbuster rentVideos(Blockbuster blockBuster) {

        blockBuster.videoMap.forEach((key, value) -> {
            int randomAge = (int) (Math.random() * 100 + 1);
            int randomRentFor = (int) (Math.random() * 5 + 1);
            try {
                blockBuster.videoMap.get(key).rent(randomAge, randomRentFor);
                System.out.println(blockBuster.videoMap.get(key));
            } catch (RentingErrorException r) {
                r.printStackTrace();
            }

        });
        blockBuster.educationalVideoMap.forEach((key, value) -> {
            int randomAge = (int) (Math.random() * 100 + 1);
            int randomRentFor = (int) (Math.random() * 5 + 1);
            try {
                blockBuster.educationalVideoMap.get(key).rent(randomAge, randomRentFor);
                System.out.println(blockBuster.educationalVideoMap.get(key));
            } catch (RentingErrorException r) {
                r.printStackTrace();
            }
        });
        return blockBuster;
    }

    public void serializeBlockbuster(Blockbuster blockBuster) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("blockbuster.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(blockBuster.videoMap);
            out.writeObject(blockBuster.educationalVideoMap);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            try {
                out.close();
                fileOut.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
