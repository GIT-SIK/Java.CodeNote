package example.util;

import java.util.concurrent.Callable;

public class TimeUtil {
    /* 실행 시간 측정 메소드 */
    public static <T> T methodExecutionTimer(Callable<T> method, String methodName, boolean allowsPrint) {
        long start = System.currentTimeMillis();
        T result = null;
        try {
            result = method.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        if(allowsPrint) {
            System.out.println();
        }
        System.out.println(methodName + "의 실행 시간: " + (end - start) / 1000.0 + "초 \n");
        return result;
    }

    public static void methodExecutionTimer(Runnable method, String methodName, boolean allowsPrint) {
        long start = System.currentTimeMillis();
        method.run();
        long end = System.currentTimeMillis();
        if(allowsPrint) {
            System.out.println();
        }
        System.out.println(methodName + "의 실행 시간: " + (end - start) / 1000.0 + "초 \n");
    }

}
