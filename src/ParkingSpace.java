import java.util.*;

public class ParkingSpace {
    private String name;
    private double space;
    public double rentalCost;
    private static int parkingID=100;
    private int ID;
    private ParkingSpace parkingSpace;
    public static List<ParkingSpace> parkingSpaceList;
    public static HashMap<Person,ParkingSpace> parkingTenants = new HashMap<>();
    private Vehicle[] vehicle = new Vehicle[1];
    private int counter=0;
    private int whichVehicle =0;
    public boolean ifRented =false;
    private boolean isThereVehicle;
    private boolean hasRentedWarehouse =false;
    private Person owner;
    private boolean ifOwner;
    public static HashMap<Warehouse, Person> warehouseTenants = Warehouse.getAuthorizedPeople();

    public ParkingSpace(String name, double space, double rentalCost){
        this.name = name;
        this.space = space;
        this.rentalCost = rentalCost;
        ID=parkingID++;
        addSpot();
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void addSpot(){
        if(parkingSpaceList ==null){
            parkingSpaceList = new ArrayList<>();
            parkingSpaceList.add(this);
        }else {
            parkingSpaceList.add(this);
        }

    }

    public static List<ParkingSpace> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public void rentParkingSpace(Person p, Warehouse w, int iloscDni){
        for(Map.Entry<Warehouse, Person> osoba : warehouseTenants.entrySet()) {
            Warehouse key = osoba.getKey();
            Person value = osoba.getValue();

            if(key.equals(w) && value.equals(p)){
                hasRentedWarehouse =true;
            }
        }
        if(hasRentedWarehouse) {
            if (iloscDni <= 14) {
                if (!ifRented) {
                    parkingSpace = this;
                    parkingTenants.put(p, this);
                    ifRented = true;
                    owner = p;
                    System.out.println(owner + " wynajal miejsce parkingowe: "+ this.name + this.ID +" w ramach magazynu: " + w.toString() + " na " + iloscDni + " dni");
                } else {
                    System.out.println("To miejsce parkingowe jest juz wynajete.");
                }
            } else {
                System.out.println("Maksymalna ilosc dni to 14.");
            }
        }else {
            System.out.println("Miejsce parkingowe mozna wynajac tylko w ramach wynajecia magazynu.");
        }

    }

    public void addVehicle(Person p, Vehicle v){
        if(!ifRented){
            System.out.println("Najpierw wynajmij miejsce zeby dodac pojazd");
        }else {
            if (p == owner) {
                try {
                    vehicle[whichVehicle++] = v;
                    isThereVehicle = true;
                    System.out.println("Pojazd zostal dodany na miejsce parkingowe.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Moze byc tylko jeden pojazd na miejscu parkingowym");
                }
            }else {
                System.out.println("Tylko wlasciciel moze dodac pojazd na miejsce parkingowe.");
            }
        }

    }

    public void removeVehicle(Person p){

        if(vehicle[0]==null){
            System.out.println("Nic nie ma na tym miejscu.");
        }else {
            if (owner == p) {
                isThereVehicle = false;
                System.out.println("Pojazd " + vehicle[0] +" zostal usuniety.");
                vehicle[0] = null;
            }else {
                System.out.println("Tylko wlasciciel moze usunac pojazd ze swojego miejsca parkingowego.");
            }
        }
    }

    public int getID() {
        return ID;
    }

    public boolean IfOwnerOfWarehouse(Person p){
        if(p== owner){
        ifOwner =true;
        }else {
            ifOwner =false;
        }
        return ifOwner;
    }

    @Override
    public String toString() {
        return "Miejsce Parkingowe{" +
                "nazwa='" + name + '\'' +
                ",Stan=" +(IfOwnerOfWarehouse(Main.getPerson())? "wynajety przez Ciebie ": (!ifRented ? "dostepny do wynajecia, ":"zajety, "))+
                (isThereVehicle ?"zaparkowano: "+ vehicle[0] : "puste miejsce ")+
                ", Parking ID:=" + ID +
                '}';
    }
}
