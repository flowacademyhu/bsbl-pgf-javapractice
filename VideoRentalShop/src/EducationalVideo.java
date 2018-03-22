public final class EducationalVideo extends Video {

    public EducationalVideo(String title, String rentableFor) {
        super(title, 0, rentableFor);
    }

    @Override
    public boolean rent(int renterAge, int numberOFDaysToRent) throws RentingErrorException {
        if (numberOFDaysToRent > 0) {
            int rentableForInt = 0;
            switch (getRentableFor()) {
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
            if((renterAge >= getRating()) && (numberOFDaysToRent <= rentableForInt && !isRented())) {
                setRented(true);
                return true;
            } else if (isRented()) {
                return false;
            } else {
                throw new RentingErrorException("You are either underage, the video is already rented or cannot be rented for the given interval.");
            }
        } else {
            throw new RentingErrorException("Renting time cannot be 0 or negative.");
        }
    }
}
