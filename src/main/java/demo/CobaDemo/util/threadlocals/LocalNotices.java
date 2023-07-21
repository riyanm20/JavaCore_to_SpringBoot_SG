package demo.CobaDemo.util.threadlocals;

import demo.CobaDemo.util.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LocalNotices {

    private static ThreadLocal<ArrayList<Message>> noticesHolder = new ThreadLocal<ArrayList<Message>>();

    private static boolean hashNotices() {
        return noticesHolder.get() != null;
    }

    private static void createIfEmpty() {
        if (!hashNotices()) {
            noticesHolder.set(new ArrayList<Message>());
        }
    }

    public static ArrayList<Message> getNotices() {
        createIfEmpty();
        return noticesHolder.get();
    }

    public void addNotice(Message notice) {
        createIfEmpty();
        noticesHolder.get().add(notice);
    }

    public static void remove() {
        noticesHolder.remove();
    }

}
