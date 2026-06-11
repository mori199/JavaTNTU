import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class LoggerUtil {
    public static void log(Class<?> clazz, String msg, String type) {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("lab5.properties"));
            if (!"on".equals(p.getProperty("logging"))) return;

            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String user = System.getProperty("user.name");
            String entry = String.format("%s %s %s %s\n", time, user, msg, type);

            FileWriter fw = new FileWriter(clazz.getSimpleName() + ".log", true);
            fw.write(entry);
            fw.close();
        } catch (Exception e) {}
    }
}
