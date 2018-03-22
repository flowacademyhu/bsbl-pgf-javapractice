public class RentalMain {

    public static void main(String[] args) {
        Blockbuster bb = new Blockbuster();

        Video starWars = new Video("Star Wars", 12, "two-day");
        EducationalVideo planetEarth = new EducationalVideo("Planet Earth", "unlimited");

        System.out.println(starWars);
        System.out.println(planetEarth);

        bb.addVideo(starWars);
        bb.addVideo(planetEarth);

        try {
            System.out.println(bb.search("Star Wars", false));
            starWars.rent(6, 1);
            System.out.println(bb.search("Star Wars", false));
            planetEarth.rent(20, 1);
            System.out.println(planetEarth);
        } catch (NotFoundException n) {
            n.printStackTrace();
        } catch (RentingErrorException r) {
            r.printStackTrace();
        }
    }
}
