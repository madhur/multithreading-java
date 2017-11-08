package in.co.madhur.common;

public class ThreadFactoryWithExceptionHandler extends NamedThreadsFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = super.newThread(r);
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return t;
    }
}
