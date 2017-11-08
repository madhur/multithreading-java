package in.co.madhur.common;

public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String handlerId;

    public ThreadExceptionHandler() {

    }
    public ThreadExceptionHandler(String handlerId) {
        this.handlerId = handlerId;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(this + " caught Exception in thread - " + t.getName() + " => " + e);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + this.hashCode() + (handlerId == null || "".equals(handlerId) ? "" : "(\"" + handlerId + "\")");
    }
}
