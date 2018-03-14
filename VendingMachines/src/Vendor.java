import vending_machine.*;

public class Vendor {

    public static void main(String[] args) {

        VendingMachine sunsetSarsaparilla = new VendingMachine(5, true);
        sunsetSarsaparilla.putMoney(100);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(50);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(95);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(120);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(100);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(110);
        info(sunsetSarsaparilla);
        sunsetSarsaparilla.putMoney(100);
        info(sunsetSarsaparilla);
    }

    public static void info(VendingMachine vm) {
        System.out.println("Remaining uses: " + vm.getCupCount() + " Money in machine: " + vm.getMoney());
    }
}
