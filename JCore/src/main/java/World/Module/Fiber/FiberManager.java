package World.Module.Fiber;

import World.ISingletonAwake;
import World.ISingletonReverseDispose;
import World.Singleton;

import java.util.concurrent.ConcurrentHashMap;

public class FiberManager extends Singleton implements ISingletonAwake, ISingletonReverseDispose {

    private final IScheduler[] schedulers = new IScheduler[3];

    private int idGenerator = 10000000;// 10000000以下为保留的用于StartSceneConfig的fiber id, 1个区配置1000个纤程，可以配置10000个区

    private ConcurrentHashMap<Integer, Fiber> fibers = new ConcurrentHashMap<>();

    @Override
    public void Awake() {

    }

    public void Update()
    {

    }

    public void LateUpdate()
    {

    }

    public void Destroy()
    {

    }
}
