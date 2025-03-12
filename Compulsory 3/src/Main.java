public class Main {
    public static void main(String[] args) {

        Airliner A1 = new Airliner("Vulturu", "F-150", "1029", 40);
        Freighter F1 = new Freighter("Turbo", "Diesel", "1234", 100);
        Drone D1 = new Drone("Elodia", "Musca", "5678", 100, 50);

        CargoCapable[] Cargo = {F1, D1};

        for (CargoCapable c : Cargo) {
            System.out.println(((Aircraft) c).getName() + " - Max Payload: " + c.getCargoCapacity());
        }
    }
}