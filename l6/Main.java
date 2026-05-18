import java.util.*;

// HashSet
class Waiter {
    int id;
    String name;

    public Waiter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Waiter)) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id && Objects.equals(name, waiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Офіціант #" + id + " " + name;
    }
}

// Для TreeSet
class Dish implements Comparable<Dish> {
    String name;
    double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Dish other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + " (" + price + " ₴)";
    }
}

// TreeMap
class CafeTable implements Comparable<CafeTable> {
    int number;

    public CafeTable(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(CafeTable other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return "Столик №" + number;
    }
}

// PriorityQueue
class Order implements Comparable<Order> {
    String dishName;
    int priority;

    public Order(String dishName, int priority) {
        this.dishName = dishName;
        this.priority = priority;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return dishName + " [Пріоритет: " + priority + "]";
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("1. HashSet");
        HashSet<Waiter> waiters = new HashSet<>();
        waiters.add(new Waiter(1, "Олег"));
        waiters.add(new Waiter(2, "Марія"));
        waiters.add(new Waiter(1, "Олег"));
        
	System.out.println("Офіціанти:");
        for (Waiter w : waiters) System.out.println(w);


        System.out.println("\n2. TreeSet");
        TreeSet<Dish> menu = new TreeSet<>();
        menu.add(new Dish("Борщ", 120.0));
        menu.add(new Dish("Кава", 45.0));
        menu.add(new Dish("Салат", 90.0));
        
	System.out.println("Меню за зростанням ціни:");
        for (Dish d : menu) System.out.println(d);


        System.out.println("\n3. TreeMap");
        TreeMap<CafeTable, Double> tableRevenue = new TreeMap<>();
        tableRevenue.put(new CafeTable(5), 1200.0);
        tableRevenue.put(new CafeTable(1), 450.0);
        tableRevenue.put(new CafeTable(3), 850.0);

        System.out.println("Касові збори:");
        tableRevenue.forEach((table, money) -> System.out.println(table + " приніс: " + money + " ₴"));


        System.out.println("\n4. LinkedList");
        LinkedList<String> history = new LinkedList<>();
        history.addLast("Стіл 1: Оплачено рахунок");
        history.addLast("Стіл 3: Прийнято замовлення");
        history.addFirst("ВАЖЛИВО: Нова бронь на вечір");

        System.out.println("Стрічка подій кафе:");
        for (String event : history) System.out.println(event);


        System.out.println("\n5. Тест ArrayList");
        ArrayList<String> specials = new ArrayList<>();
        specials.add("Суп дня");
        specials.add("Пиріг з вишнею");
        specials.add("Лимонад");
        
        System.out.println("Особливі пропозиції сьогодні:");
        System.out.println("Перша позиція: " + specials.get(0));


        System.out.println("\n6. Queue");
        Queue<String> kitchenQueue = new LinkedList<>();
        kitchenQueue.add("Замовлення на Борщ");
        kitchenQueue.add("Замовлення на Піцу");

        System.out.println("Кухня видає страву: " + kitchenQueue.poll());
        System.out.println("Наступна в черзі на приготування: " + kitchenQueue.peek());


        System.out.println("\n7. PriorityQueue");
        PriorityQueue<Order> vipQueue = new PriorityQueue<>();
        vipQueue.add(new Order("Кава для звичайного столика", 2));
        vipQueue.add(new Order("Стейк для VIP-зали", 1));
        vipQueue.add(new Order("Вода для десертного столика", 3));

        System.out.println("Черга приготування страв за рівнем важливості:");
        while (!vipQueue.isEmpty()) {
            System.out.println(vipQueue.poll());
        }
    }
}
