package code.stream.util;

public class TimeUtil {
    /* 실행 시간 측정 메소드 */
    public static void methodExecutionTimer(Runnable method, String methodName) {
        long start = System.currentTimeMillis();
        method.run();
        long end = System.currentTimeMillis();
        System.out.println(methodName + "의 실행 시간: " + (end - start) / 1000.0 + "초 \n");
    }
}
