import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LabWork5 {
    public static void main(String[] args) throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("Bundle", Locale.ENGLISH);

        String info = String.format("OS: %s, User: %s, Time: %s\n", 
            System.getProperty("os.name"), System.getProperty("user.name"), new Date());
        Files.write(Paths.get("system_info.txt"), info.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Cafe cafe = new Cafe("Blue Cafe");
        cafe.createZone(); 
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cafe.ser"));
        out.writeObject(cafe);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("cafe.ser"));
        Object obj = in.readObject();
        in.close();

        if (args.length == 0) {
            System.out.println(bundle.getString("help"));
            return;
        }
        
        switch (args[0]) {
            case "systems_info":
                Files.readAllLines(Paths.get("system_info.txt")).forEach(System.out::println);
                break;
            case "list":
                File[] logs = new File(".").listFiles((d, n) -> n.endsWith(".log"));
                if (logs != null) {
                    for (File f : logs) System.out.println(f.getName());
                }
                break;
            case "printlog":
                if (args.length == 3) {
                    List<String> lines = Files.readAllLines(Paths.get(args[1] + ".log"));
                    if ("1".equals(args[2])) Collections.reverse(lines);
                    lines.forEach(System.out::println);
                }
                break;
            case "help":
                System.out.println(bundle.getString("help"));
                break;
        }
    }
}
