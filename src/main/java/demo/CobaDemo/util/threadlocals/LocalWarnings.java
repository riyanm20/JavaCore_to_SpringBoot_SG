package demo.CobaDemo.util.threadlocals;

import demo.CobaDemo.util.Message;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
public class LocalWarnings {

    private static ThreadLocal<ArrayList<Message>> warningsHolder = new ThreadLocal<ArrayList<Message>>();

    private static boolean hasWarnings() {
        return warningsHolder.get() !=null;
    }

    private static void createIfEmpty() {
        if (!hasWarnings()) {
            warningsHolder.set(new ArrayList<Message>());
        }
    }

    public static ArrayList<Message> getWarnings() {
        createIfEmpty();
        return warningsHolder.get();
    }

    public void addWarnings(Message warning) {
        getWarnings().add(warning);
    }

    public static void remove() {
        warningsHolder.remove();
    }

}
