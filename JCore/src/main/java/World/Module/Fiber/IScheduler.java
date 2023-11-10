package World.Module.Fiber;

import Core.IDisposable;

public interface IScheduler extends IDisposable {

    void Add(int fiberId);


}
