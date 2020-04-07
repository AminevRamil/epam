package shkryl.task12.racecondition.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private static int value = 0;

    private static Logger logger = LoggerFactory.getLogger(Counter.class);

    public static void incrementValue() {
        int val = value;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        val = val + 1;
        value = val;
    }

    public static void showValue() {
        logger.info("Значение поля value в условиях racecondition = {}",value);
    }
}
