import java.io.Serializable;

public class Video implements Rentable, Serializable {

    private String title;
    private boolean isRented;
    private String rentableFor;
    private int rating;

    public Video(String title, int rating, String rentableFor) {
        this.title = title;
        if(rating != 0 || rating != 12 || rating != 16 || rating != 18) {
            this.rating = rating;

        } else {
            System.out.println(("Wrong rating value input."));
        }
        if(!rentableFor.equals("one-day") || !rentableFor.equals("two-day") || !rentableFor.equals("unlimited")) {
            this.rentableFor = rentableFor;
        } else {
            System.out.println("Wrong rentable for value input.");
        }

    }

    @Override
    public boolean rent(int renterAge, int numberOFDaysToRent) throws RentingErrorException {
        if (numberOFDaysToRent > 0) {
            int rentableForInt = 0;
            switch (rentableFor) {
                case "one-day":
                    rentableForInt = 1;
                    break;
                case "two-day":
                    rentableForInt = 2;
                    break;
                case "unlimited":
                    rentableForInt = numberOFDaysToRent;
                    break;
            }
            if((renterAge >= rating) && (numberOFDaysToRent <= rentableForInt && !isRented)) {
                isRented = true;
                return true;
            } else if (isRented) {
                return false;
            } else {
                throw new RentingErrorException("You are either underage, the video is already rented or cannot be rented for the given interval.");
            }
        } else {
            throw new RentingErrorException("Renting time cannot be 0 or negative.");
        }

    }

    @Override
    public void returnTape() {
        setRented(false);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRentableFor() {
        return rentableFor;
    }

    public void setRentableFor(String rentableFor) {
        this.rentableFor = rentableFor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", is it rented=" + isRented +
                ", rentable for='" + rentableFor + '\'' +
                ", rating=" + rating;
    }
}
