interface Orderable {
    void prepare();
}

abstract class CateringEstablishment {
    protected String name;

    public CateringEstablishment(String name) {
        this.name = name;
    }

    public abstract void describe();
}

class Menu {
    protected String menuType;

    public void showMenuType() {
        System.out.println("Menu type: " + menuType);
    }
}

class EspressoMenu extends Menu {
    public EspressoMenu() {
        this.menuType = "Espresso & Coffee Drinks";
    }
}

class DessertMenu extends Menu {
    public DessertMenu() {
        this.menuType = "Desserts & Pastries";
    }
}

public class Cafe extends CateringEstablishment {

    private Menu menu;

    public Cafe(String name) {
        super(name);
        this.menu = new EspressoMenu();
    }

    @Override
    public void describe() {
        System.out.println("Cafe name: " + name);
        menu.showMenuType(); 
    }

    public static class Dish implements Orderable {
        private String dishName;

        public Dish(String dishName) {
            this.dishName = dishName;
        }

        @Override
        public void prepare() {
            System.out.println(dishName + " is being prepared by the barista!");
        }

        public static void dishFacts() {
            System.out.println("Coffee beans are actually seeds from a fruit called a coffee cherry.");
        }
    }

    public void createZone() {
        class VIPZone {
            private String zoneName;

            public VIPZone(String zoneName) {
                this.zoneName = zoneName;
            }

            public void showZoneInfo() {
                System.out.println("Zone name: " + zoneName + " is ready for premium guests.");
            }
        }

        VIPZone zone = new VIPZone("Dream Lounge");
        zone.showZoneInfo();
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Blue Cafe");

        cafe.describe();

        Dish dish = new Dish("Croissant");
        dish.prepare();
        Dish.dishFacts();

        cafe.createZone();
    }
}
