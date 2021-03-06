import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main extends JFrame{
    public static List<ConsumerWarehouse> warehousePremises;
    public static List<ServiceWarehouse> servicePremises;
    public static List<CarServiceSpot> repairPlaces;
    public static List<IndependentCarServiceSpot> serviceSpots;
    public static Person person;
    public static Object object;
    public static Vehicle vehicle;
    public static CarService carService;
    public static ParkingSpace parkingSpace;
    public static Warehouse warehouse;
    public static List<Person> peopleList = new ArrayList<>();
    public static List<Warehouse> warehouseList = new ArrayList<>();
    public static List<Warehouse> freeWarehouseList = new ArrayList<>();
    public static List<Warehouse> occupiedWarehouseList = new ArrayList<>();
    public static Set<Object> objectsList = new HashSet<>();
    public static Set<Vehicle> vehiclesList = new HashSet<>();
    public static List<ParkingSpace> parkingSpaceList = new LinkedList<>();
    public static List<CarService> carServiceList = new LinkedList<>();
    public static List<ParkingSpace> freeParkingSpaceList = new LinkedList<>();
    public static List<Warehouse> authorizedWarehouses = new ArrayList<>();
    public static int number;
    public static String text;
    public static CarServiceSpot carServiceSpot;
    public static IndependentCarServiceSpot independentCarServiceSpot;
    public static boolean typeRight = false;
    public static boolean needParking;
    public static Service service;
    public static boolean exit=false;



    public static void main(String[] args) throws Exception {
        int select;
        Homepage homepage = new Homepage();
        // TWORZENIE OBIEKTY
        service = new Service("U Zbycha", 1, 10, 50, 3, 1);

        ConsumerWarehouse cw1 = new ConsumerWarehouse("ABC", 2000, 500, LocalDate.of(2021, 2, 26), LocalDate.of(2022, 6, 24));
        ConsumerWarehouse cw2 = new ConsumerWarehouse("BCD", 300, 200, LocalDate.of(2021, 11, 28), LocalDate.of(2022, 6, 24));
        ConsumerWarehouse cw3 = new ConsumerWarehouse("DEF", 300, 10, LocalDate.of(2021, 7, 11), LocalDate.of(2022, 7, 1));
        ConsumerWarehouse cw4 = new ConsumerWarehouse("DGC", 300, 10, LocalDate.of(2021, 9, 11), LocalDate.of(2022, 7, 12));
        ConsumerWarehouse cw5 = new ConsumerWarehouse("EGS", 300, 10, LocalDate.of(2021, 4, 11), LocalDate.of(2022, 7, 4));
        ServiceWarehouse sw1 = new ServiceWarehouse("FGH", 45, 400, LocalDate.of(2021, 2, 26), LocalDate.of(2022, 7, 30));
        ServiceWarehouse sw2 = new ServiceWarehouse("IJK", 30, 1250, LocalDate.of(2021, 8, 8), LocalDate.of(2022, 7, 9));
        ServiceWarehouse sw3 = new ServiceWarehouse("FGH", 45, 400, LocalDate.of(2021, 3, 26), LocalDate.of(2022, 7, 17));
        ServiceWarehouse sw4 = new ServiceWarehouse("IJK", 30, 1250, LocalDate.of(2021, 9, 8), LocalDate.of(2022, 7, 15));
        ServiceWarehouse sw5 = new ServiceWarehouse("FGH", 45, 400, LocalDate.of(2021, 12, 26), LocalDate.of(2022, 7, 7));

        Person p1 = new Person("Adam", "Kowalski", 132323222, "Warszawa, Gorecka 5", LocalDate.of(2020, 6, 28));
        Person p2 = new Person("Pawe??", "Jarosz", 232321232, "Czestochowa, Warynskiego 5", LocalDate.of(2019, 4, 6));
        Person p3 = new Person("Marek", "Wilusz", 023021202, "Warszawa, Mokotowska 5", LocalDate.of(2020, 11, 11));
        Person p4 = new Person("Adam", "Ozga", 1232320202, "Warszawa, Kielecka 25a", LocalDate.of(2021, 1, 26));
        Person p5 = new Person("Micha??", "Browar", 523302102, "Raszyn, Warszawska 135", LocalDate.of(2021, 3, 7));

        ParkingSpace ps1 = new ParkingSpace("Miejsce A", 10, 200);
        ParkingSpace ps2 = new ParkingSpace("Miejsce B", 10, 200);
        ParkingSpace ps3 = new ParkingSpace("Miejsce C", 7, 150);

        Object o1 = new Object("rower", 20);
        Object o2 = new Object("pralka", 10, 5, 3);
        Object o3 = new Object("telewizor", 179);
        Object o4 = new Object("obraz", 2);
        Object o5 = new Object("wiadro", 2, 2, 2);

        CarServiceSpot Ics1 = new CarServiceSpot("XYZ", 100);
        CarServiceSpot Ics2 = new CarServiceSpot("ZYX", 20);
        CarServiceSpot Ics3 = new CarServiceSpot("YZX", 100);

        IndependentCarServiceSpot icss1 = new IndependentCarServiceSpot("ZZZ", 30);

        Motorcycle m1 = new Motorcycle("Ducati", "scigacz", 1000, 234);
        Amphibian a1 = new Amphibian("ISUZU", "wojskowy", 7000, 2);
        CityCar c1 = new CityCar("Toyota", "miejskie", 1200, "automatyczna");
        OffRoadCar of1 = new OffRoadCar("Nissan", "Offroadowy", 4200, "4x4");


        // DODAWANIE POMIESZCZEN, MIEJSC NAPRAWCZYCH
        warehousePremises = List.of(ConsumerWarehouse.getConsumerWarehouseList());
        servicePremises = List.of(ServiceWarehouse.getServicePremisesList());
        repairPlaces = List.of(CarServiceSpot.getCarServiceSpots());
        serviceSpots = List.of(IndependentCarServiceSpot.getIndependentCarServiceSpots());
        peopleList = Person.getPersonList();
        warehouseList = Warehouse.getWarehousesList();
        objectsList = Object.getObjectList();
        vehiclesList = Vehicle.getVehiclesList();
        parkingSpaceList = ParkingSpace.getParkingSpaceList();
        carServiceList = CarService.getCarServiceList();

        // FUNKCJONALNOSC
            //your examples


        // MENU
        while (!exit) {
            System.out.println();
            System.out.println("----Menu----");
            System.out.println("WYBIERZ OPCJE:");
            System.out.println(" 1 - Wyjscie z programu");
            System.out.println(" 2 - Wybierz osobe");
            System.out.println(" 3 - Wyswietl informacje");
            System.out.println(" 4 - Wyswietl wolne pomieszczenia");
            System.out.println(" 5 - Wynajmij pomieszczenie");
            System.out.println(" 6 - Sprawdz zawartosc pomieszczenia");
            System.out.println(" 7 - Wloz przedmiot do magazynu");
            System.out.println(" 8 - Dodaj uprawnienia do magazynu");
            System.out.println(" 9 - Zaparkuj pojazd na miejscu parkingowym");
            System.out.println(" 10 - Zabierz przedmiot z magazynu");
            System.out.println(" 11 - Zabierz auto z parkingu");
            System.out.println(" 12 - Wynajmij miejsce serwisowe lub naprawcze");
            System.out.println(" 13 - Zglos potrzebe naprawy lub rozpocznij serwisowanie pojazdu");
            System.out.println(" 14 - Zakoncz naprawe pojazdu");
            System.out.println(" 15 - Zapisz aktualny stan");
            System.out.println(" 16 - Uruchom up??yw czasu");


            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {
                sc.next();
            }
            select = sc.nextInt();
            switch (select) {

                case 1:
                    exit();
                    break;
                case 2:
                    choosePerson(sc);
                    break;
                case 3:
                    if (person == null) {
                        System.out.println("Najpierw wybierz Osobe:");
                        choosePerson(sc);
                    }
                    displayPersonDetails();
                    break;
                case 4:
                    System.out.println("Lista wolnych magazynow");
                    freeWarehouseList = getFreeWarehouseList();
                    System.out.println(freeWarehouseList);
                    break;
                case 5:
                    if (person == null) {
                        System.out.println("Najpierw wybierz Osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz magazyn:");
                    chooseFreeWarehouse(sc);
                    rentParking(sc);
                    break;
                case 6:
                    if (person == null) {
                        System.out.println("Najpierw wybierz Osobe:");
                        choosePerson(sc);
                    }
                    if (person.getRentedWarehousesList().isEmpty()) {
                        System.out.println("Osoba nic nie wynajmuje.");
                    } else {
                        displayPersonDetails();
                        System.out.println("Wybierz id magazynu by zobaczyc jego zawartosc:");
                        displayListOfRentedPremises(sc);
                    }
                    break;
                case 7:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    addItemToWarehouse(sc);
                    break;
                case 8:
                    if (person == null) {
                        System.out.println("Wybierz osobe ktorej chcesz nadac uprawnienia:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz magazyn do ktorego nadasz uprawnienia:");
                    chooseWarehouse(sc);
                    warehouse.addPermission(person);
                    break;
                case 9:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz Miejsce parkingowe:");
                    displayParkingSpace(sc);
                    System.out.println("Wybierz pojazd:");
                    chooseVehicle(sc);
                    parkingSpace.addVehicle(person, vehicle);
                    break;
                case 10:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz magazyn:");
                    chooseWarehouse(sc);
                    System.out.println("Wybierz przedmiot:");
                    System.out.println(warehouse.getWarehouseItems());
                    if (warehouse.getWarehouseItems().isEmpty()) {
                        System.out.println("Brak przedmiotow w magazynie.");
                        break;
                    }
                    number = sc.nextInt();
                    objectsList.forEach(
                            O -> {
                                if (O.getID() == number)
                                    object = O;

                            }
                    );
                    warehouse.takeOutItem(person, object);
                    break;
                case 11:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz miejsce parkingowe:");
                    displayParkingSpace(sc);

                    parkingSpace.removeVehicle(person);
                    break;
                case 12:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz pojazd:");
                    chooseVehicle(sc);
                    chooseCarService(sc);
                    carService.rentSpot(person, vehicle);
                    break;
                case 13:
                    if (person == null) {
                        System.out.println("Wybierz osobe:");
                        choosePerson(sc);
                    }
                    System.out.println("Wybierz pojazd:");
                    chooseVehicle(sc);
                    System.out.println("Czy chcesz samodzielnie serwisowac pojazd? Wpisz: T jesli TAK. Wpisz dowolny znak jesli ma byc naprawiany przez mechanik??w:");
                    text = sc.next();
                    if (text.equals("T") || text.equals("t") || text.equals("TAK") || text.equals("tak")) {
                        System.out.println("Wybrano samodzielna naprawe.");
                        System.out.println("Wybierz miejsce serwisowe:");
                        chooseServiceSpot(sc);
                        independentCarServiceSpot.startSelfRepair(person, vehicle);
                    } else {
                        System.out.println("Wybrano naprawe przez mechanik??w.");
                        System.out.println("Wybierz miejsce naprawcze:");
                        chooseRepairPlace(sc);
                        carServiceSpot.startRepair(vehicle);
                    }
                    break;
                case 14:
                    System.out.println("Jaki rodzaj naprawy chcesz zakonczyc? Wpisz: TAK jesli Samodzielna lub wpisz dowolny znak jesli NIE.");
                    text = sc.next();
                    if (text.equals("t") || text.equals("T") || text.equals("TAK") || text.equals("tak") || text.equals("Tak")) {
                        finishRepairOfICSS(sc);
                    } else {
                        finishRepairOfCSS(sc);
                    }
                    break;
                case 15:
                    writeToFile();
                    break;
                case 16:
                    TimeLapseThread t1 = new TimeLapseThread();
                    LeaseCheckingThread t2 = new LeaseCheckingThread();
                    t1.start();
                    t2.start();
                    break;
                default:
                    System.out.println("Prosze podac numer opcji zgodny z MENU.");
            }
        }
    }

    public static void exit(){
        exit=true;
    }

    private static void choosePerson(Scanner sc) {
        System.out.println(peopleList);
        number = sc.nextInt();
        peopleList.forEach(
                P -> {
                    if (P.getId() == number)
                        person = P;
                }
        );

        System.out.println("Wybrano: " + person.firstName + " " + person.lastName);
        System.out.println();
    }

    private static void chooseWarehouse(Scanner sc) {
        System.out.println(warehouseList);
        number = sc.nextInt();
        warehouseList.forEach(
                W -> {
                    if (W.getId() == number) {
                        warehouse = W;
                    }
                }

        );

    }

    public static void finishRepairOfICSS(Scanner sc) {

        Map<IndependentCarServiceSpot, Vehicle> lista = IndependentCarServiceSpot.getAllServicedVehiclesList();
        if (!lista.isEmpty()) {
            if(person ==null) {
                System.out.println("Wybierz osobe:");
                choosePerson(sc);
            }
            System.out.println("Wybierz miejsce serwisowe:");
            System.out.println(lista);
            number = sc.nextInt();
            for (Map.Entry<IndependentCarServiceSpot, Vehicle> entry : lista.entrySet()) {
                if (entry.getKey().getId() == number)
                    independentCarServiceSpot = entry.getKey();

            }
            independentCarServiceSpot.finishSelfRepair(person);
        } else
            System.out.println("Nie ma obecnie zadnych napraw.");


    }

    private static void finishRepairOfCSS(Scanner sc) {
        Map<CarServiceSpot, Vehicle> lista = CarServiceSpot.getAllRepairedVehicles();
        if (!lista.isEmpty()) {
            System.out.println("Wybierz miejsce Naprawcze:");
            System.out.println(lista);
            number = sc.nextInt();
            for (Map.Entry<CarServiceSpot, Vehicle> entry : lista.entrySet()) {
                if (entry.getKey().getId() == number)
                    carServiceSpot = entry.getKey();

            }
            carServiceSpot.finishRepair();
        } else
            System.out.println("Nie ma obecnie zadnych napraw.");
    }

    private static void chooseFreeWarehouse(Scanner sc) {
        freeWarehouseList = getFreeWarehouseList();
        System.out.println(freeWarehouseList);
        number = sc.nextInt();
        freeWarehouseList.forEach(
                W -> {
                    if (W.getId() == number) {
                        warehouse = W;
                    }
                }

        );
    }

    private static void rentParking(Scanner sc) {

        while (!typeRight) {
            System.out.println("Czy chcesz wynajac miejsce parkingowe? Wpisz:  T  je??li tak, wpisz:  N  je??li nie:");
            text = sc.next();
            if (text.equals("T") || text.equals("t") || text.equals("tak") || text.equals("TAK") || text.equals("Tak")) {
                typeRight = true;
                needParking = true;
            } else if (text.equals("N") || text.equals("n") || text.equals("nie") || text.equals("NIE")) {
                typeRight = true;
                needParking = false;
            } else {
                System.out.println("Nie wpisales dobrego znaku.");
            }
        }

        if (needParking) {
            System.out.println("Wybierz miejsce parkingowe ktore chcesz wynajac.");
            chooseParkingSpace(sc);
            warehouse.rentWarehouse(person, parkingSpace);
        } else {
            warehouse.rentWarehouse(person, null);
        }
        typeRight =false;
    }

    private static void displayListOfRentedPremises(Scanner sc) {
        number = sc.nextInt();
        person.getRentedWarehousesList().forEach(
                M -> {
                    if (M.getId() == number) {
                        warehouse = M;
                    }
                }
        );
        System.out.print(warehouse.getWarehouseItems());

    }

    private static void addItemToWarehouse(Scanner sc) throws TooManyThingsException {

        for (Map.Entry<Warehouse, Person> entry : Warehouse.authorizedPeople.entrySet()) {
            Warehouse key = entry.getKey();
            Person value = entry.getValue();
            if (value.equals(person) && !authorizedWarehouses.contains(key)) {
                authorizedWarehouses.add(key);
            }
        }
        if (!authorizedWarehouses.isEmpty()) {
            System.out.println("Wybierz magazyn do ktorego chcesz wlozyc przedmiot:");
            System.out.println(authorizedWarehouses);
            number = sc.nextInt();
            authorizedWarehouses.forEach(
                    W -> {
                        if (W.getId() == number) {
                            warehouse = W;
                        }
                    });
            System.out.println("Wybierz przedmiot:");
            warehouse.getWarehouseItems();
            chooseItem(sc);
            warehouse.addItem(person, object);
        } else {
            System.out.println("Nie masz uprawnien do zadnego magazynu.");
        }
    }

    private static void chooseParkingSpace(Scanner sc) {
        displayFreeWarehouseList();
        number = sc.nextInt();
        freeParkingSpaceList.forEach(
                L -> {
                    if (L.getID() == number)
                        parkingSpace = L;
                }
        );
    }

    private static void displayParkingSpace(Scanner sc) {
        System.out.println(parkingSpaceList);
        number = sc.nextInt();
        parkingSpaceList.forEach(
                L -> {
                    if (L.getID() == number)
                        parkingSpace = L;

                }

        );
    }

    private static void chooseItem(Scanner sc) {
        System.out.println(objectsList);
        number = sc.nextInt();
        objectsList.forEach(
                O -> {
                    if (O.getID() == number)
                        object = O;
                }
        );
    }

    private static void chooseVehicle(Scanner sc) {
        System.out.println(vehiclesList);
        number = sc.nextInt();
        vehiclesList.forEach(
                V -> {
                    if (V.getVehicleID() == number)
                        vehicle = V;
                }
        );
        System.out.println("Wybrano: "+ vehicle);
        System.out.println();
    }

    private static void chooseRepairPlace(Scanner sc) {
        System.out.println(repairPlaces);
        number = sc.nextInt();
        repairPlaces.forEach(
                V -> {
                    if (V.getId() == number)
                        carServiceSpot = V;
                }
        );
    }

    private static void chooseServiceSpot(Scanner sc) {
        System.out.println(serviceSpots);
        number = sc.nextInt();
        serviceSpots.forEach(
                V -> {
                    if (V.getId() == number)
                        independentCarServiceSpot = V;
                }
        );
    }

    private static void chooseCarService(Scanner sc) {
        System.out.println("Wybierz miejsce ktore chcesz wynajac");
        System.out.println(carServiceList);
        number = sc.nextInt();
        carServiceList.forEach(
                LMP -> {
                    if (LMP.getId() == number)
                        carService = LMP;
                }
        );
    }

    public static List<Warehouse> getFreeWarehouseList() {
        freeWarehouseList = warehouseList.stream()
                .filter(e -> !e.ifBusy)
                .collect(toList());
        return freeWarehouseList;
    }

    public static List<Warehouse> getOccupiedWarehouseList() {
        occupiedWarehouseList = warehouseList.stream()
                .filter(e -> e.ifBusy)
                .collect(toList());
        return occupiedWarehouseList;
    }

    public static void displayFreeWarehouseList() {
        freeParkingSpaceList = parkingSpaceList.stream()
                .filter(e -> !e.ifRented)
                .collect(toList());
        System.out.println(freeParkingSpaceList);
    }

    public static void displayPersonDetails() {
        System.out.println(person.toString());
        System.out.print("Wynajete miejsca: ");
        person.getRentedWarehousesList().forEach(info -> {
            System.out.println(info);
        });
        if (person.getRentedWarehousesList().isEmpty()) {
            System.out.print("brak. ");
        }

        List<Warehouse> magazyny = new LinkedList<>();
        for (Map.Entry<Warehouse, Person> os : Warehouse.authorizedPeople.entrySet()) {
            Warehouse key = os.getKey();
            Person value = os.getValue();
            if (value.equals(person)) {
                magazyny.add(key);
            }
        }
        System.out.println("Posiadane uprawnienia:" + magazyny);
    }

    public static void getWarehouseItems(PrintWriter writer) {
        writer.println("Przedmioty w magazynach: ");
        for (Warehouse l : warehouseList) {
            if(!l.getWarehouseItems().isEmpty()) writer.println(l.getWarehouseItems());
        }
        writer.println();
    }

    public static Person getPerson() {
        return person;
    }

    public static Map<CarServiceSpot,Queue<Vehicle>> getQueueWaitingForRepairCSS(){
        Map<CarServiceSpot,Queue<Vehicle>> map = new HashMap<>();
        for (CarServiceSpot c : repairPlaces) {
            if(!c.getVehicleQueue().isEmpty())
            map.put(c,c.getVehicleQueue());
        }
        return map;
    }

    public static Map<IndependentCarServiceSpot,Queue<Vehicle>> getQueueWaitingForRepairICSS(){
        Map<IndependentCarServiceSpot,Queue<Vehicle>> map = new HashMap<>();
        for (IndependentCarServiceSpot c : serviceSpots) {
            if(!c.getQueueOfWaitingVehicles().isEmpty())
                map.put(c,c.getQueueOfWaitingVehicles());
        }
        return map;
    }

    public static Map<CarService, Set<Vehicle>> getHistoryOfRepairs(){
        Map<CarService, Set<Vehicle>> map = CarService.getRepairHistory();
        return map;
    }

    public static void writeToFile() {
        PrintWriter writer = null;
        try {
            File file = new File("warehouses.txt");
            file.createNewFile();
            writer = new PrintWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(service);
        writer.println();
        voidCollection("Lista pomieszczen: ", writer, warehouseList);
        voidCollection("Wolne magazyny: ", writer, getFreeWarehouseList());
        voidCollection("Zajete magazyny: ", writer, getOccupiedWarehouseList());
        voidCollection("Lista osob: ", writer, peopleList);
        voidCollection("Lista przedmiotow: ", writer, objectsList);
        voidCollection("Lista osob wynajmujacych: ", writer, Warehouse.getTenantsList());
        writer.println();
        getWarehouseItems(writer);
        writer.println();
        writer.close();

        PrintWriter writer2 = null;
        try {
            File file2 = new File("services.txt");
            file2.createNewFile();
            writer2 = new PrintWriter(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer2.println(service);
        writer2.println();
        voidCollection("Miejsca parkingowe: ",writer2, parkingSpaceList);
        voidCollection("Miejsca serwisowe: ",writer2, serviceSpots);
        voidCollection("Miejsca naprawcze:",writer2, repairPlaces);
        voidCollection("Lista pojazdow: " ,writer2, vehiclesList);
        voidCollection2("Lista pojazdow naprawianych: ",writer2, CarServiceSpot.getAllRepairedVehicles());
        voidCollection4("Lista oczekujacych na naprawe: ",writer2, getQueueWaitingForRepairCSS());
        voidCollection3("Lista pojazdow serwisowanych",writer2, IndependentCarServiceSpot.getAllServicedVehiclesList());
        voidCollection5("Lista oczekujacych na serwis: ",writer2, getQueueWaitingForRepairICSS());
        voidCollection6("Historia napraw: ",writer2, getHistoryOfRepairs());

        writer2.println();
        writer2.close();
    }

    public static <T> void voidCollection(String message, PrintWriter wr, Collection<T> collection) {
        wr.println(message);
        collection.forEach(wr::println);
        wr.println();
    }

    public static void voidCollection(String message, PrintWriter wr, Map<Person, List<Warehouse>> collection) {
        wr.println(message);
        collection.forEach((person, warehouses) -> wr.println(person + " " + warehouses));
        wr.println();
    }

    public static void voidCollection2(String message, PrintWriter wr, Map<CarServiceSpot, Vehicle> collection) {

        wr.println(message);
        collection.forEach((carServiceSpot, vehicle) -> wr.println(carServiceSpot + ":  " + vehicle));
        wr.println();
    }

    public static void voidCollection3(String message, PrintWriter wr, Map<IndependentCarServiceSpot, Vehicle> collection) {
        wr.println(message);
        collection.forEach((carServiceSpot, vehicle) -> wr.println(carServiceSpot + ":  " + vehicle));
        wr.println();
    }

    public static void voidCollection4(String message, PrintWriter wr, Map<CarServiceSpot,Queue<Vehicle>> collection) {
        wr.println(message);
        collection.forEach((c, v) -> wr.println(c + ":  " + v));
        wr.println();
    }

    public static void voidCollection5(String message, PrintWriter wr, Map<IndependentCarServiceSpot,Queue<Vehicle>> collection) {
        wr.println(message);
        collection.forEach((c, v) -> wr.println(c + ":  " + v));
        wr.println();
    }

    public static void voidCollection6(String message, PrintWriter wr, Map<CarService, Set<Vehicle>> collection){
        wr.println(message);
        collection.forEach((c, v) -> wr.println(c + ":  " + v));
        wr.println();
    }
}
