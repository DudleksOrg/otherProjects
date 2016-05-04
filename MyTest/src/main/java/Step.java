import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by adudarev on 04.05.2016.
 */
public class Step {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static Integer set(){
        return atomicInteger.incrementAndGet();
    }

    public static void nullify(){
        atomicInteger.set(0);
    }
}
