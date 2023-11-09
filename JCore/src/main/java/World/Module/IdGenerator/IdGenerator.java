package World.Module.IdGenerator;

import World.ISingletonAwake;
import World.Singleton;

public class IdGenerator extends Singleton implements ISingletonAwake {
    public static final int MaxZone = 1024;

    public static final int Mask14bit = 0x3fff;
    public static final int Mask30bit = 0x3fffffff;
    public static final int Mask20bit = 0xfffff;

    @Override
    public void Dispose() {

    }

    @Override
    public void BeginInit() {

    }

    @Override
    public void EndInit() {

    }

    @Override
    public void Awake() {

    }
}
