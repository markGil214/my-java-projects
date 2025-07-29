class InkCartridge{
    int ink;

    InkCartridge(int ink) {
        this.ink = ink;
    }

    boolean hasInk() {
        return ink > 0;
    }

    int inkUsed() {
        return ink--;
    }

    int checkInk() {
        return ink;
    }
}

class Printer {
    InkCartridge inkCartridge;

    Printer(InkCartridge inkCartridge) {
        this.inkCartridge = inkCartridge;
    }

    void print(String display) {
        if(inkCartridge.hasInk()) {
            System.out.println("You printed: " + display);
            inkCartridge.inkUsed();

            System.out.println("Ink remaining: " + inkCartridge.checkInk());
        } else {
            System.out.println("You have no remaining ink.");
            System.out.println("Ink remaining: " + inkCartridge.checkInk());
        }
    }


}


public class Main {
    public static void main(String[] args) {
        InkCartridge inkCartridge = new InkCartridge(3);
        Printer printer = new Printer(inkCartridge);

        printer.print("mama mo");

    }
}
