package World.Module.Log;

import World.ISingletonAwake;
import World.Singleton;

public class Logger extends Singleton implements ISingletonAwake {
    private ILog log;

    public ILog GetLog()
    {
        return log;
    }

    public void SetLog(ILog log)
    {
        this.log = log;
    }

    @Override
    public void Awake() {

    }
}
