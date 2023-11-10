package World.Module.Log;

import World.Module.Fiber.Fiber;
import World.Module.Fiber.FiberManager;

public class Log {


    private static final int TraceLevel = 1;
    private static final int DebugLevel = 2;
    private static final int InfoLevel = 3;
    private static final int WarningLevel = 4;


    private static ILog GetLog()
    {
        return null;
    }


    public static void Error(String msg)
    {

    }
}
