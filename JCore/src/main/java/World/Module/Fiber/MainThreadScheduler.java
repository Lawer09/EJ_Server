package World.Module.Fiber;

import Core.ThreadSynchronizationContext;

import java.util.concurrent.ConcurrentLinkedQueue;

public class MainThreadScheduler implements IScheduler{

    private final ConcurrentLinkedQueue<Integer> idQueue = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<Integer> addIds = new ConcurrentLinkedQueue<>();
    private FiberManager fiberManager;
    private final ThreadSynchronizationContext synchronizationContext = new ThreadSynchronizationContext();

    public MainThreadScheduler(FiberManager fiberManager) {
        //SynchronizationContext.SetSynchronizationContext(this.threadSynchronizationContext);
        this.fiberManager = fiberManager;
    }


    public void Update()
    {
        //TODO
    }

    public void LateUpdate()
    {
        //TODO
    }

    @Override
    public void Add(int fiberId) {
        this.addIds.add(fiberId);
    }

    @Override
    public void Dispose() {
        this.addIds.clear();
        this.idQueue.clear();
    }
}
