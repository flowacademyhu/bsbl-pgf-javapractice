public interface Rentable {

    boolean rent(int num1, int num2) throws RentingErrorException;

    void returnTape();
}
