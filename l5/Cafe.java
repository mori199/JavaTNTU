import java.io.Serializable;

interface Orderable extends Serializable {
    void prepare();
}

abstract class CateringEstablishment implements Serializable {
    protected String name;
    public CateringEstablishment(String name) { this.name = name; }
    public abstract void describe();
}

class Menu implements Serializable {
    protected String menuType;
    public void showMenuType() { System.out.println("Menu type: " + menuType); }
}

class EspressoMenu extends Menu {
    public EspressoMenu() { this.menuType = "Espresso & Coffee Drinks"; }
}

class DessertMenu extends Menu {
    public DessertMenu() { this.menuType = "Desserts & Pastries"; }
}

public class Cafe extends CateringEstablishment {
    private Menu menu;

    public Cafe(String name) {
        super(name);
        this.menu = new EspressoMenu();
        LoggerUtil.log(Cafe.class, "Cafe created", "message");
    }

    @Override
    public void describe() {
        System.out.println("Cafe name: " + name);
        menu.showMenuType(); 
    }

    public static class Dish implements Orderable {
        private String dishName;
        public Dish(String dishName) { this.dishName = dishName; }

        @Override
        public void prepare() { System.out.println(dishName + " is preparing!"); }
        
        public static void dishFacts() { System.out.println("Coffee beans are seeds."); }
    }

    public void createZone() {
        class VIPZone implements Serializable {
            private String zoneName;
            public VIPZone(String zoneName) { this.zoneName = zoneName; }
            public void showZoneInfo() { System.out.println("Zone: " + zoneName); }
        }

        try {
            VIPZone zone = new VIPZone("Dream Lounge");
            zone.showZoneInfo();
            int error = 10 / 0; 
        } catch (Exception e) {
            LoggerUtil.log(Cafe.class, "Math error", "exception");
        }
    }
}
