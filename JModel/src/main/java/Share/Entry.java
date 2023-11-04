package Share;

import Helper.WinPeriod;
import World.Module.IdGenerator.IdGenerator;
import World.World;

import java.util.concurrent.CompletableFuture;

public class Entry {
    public static void Init()
    {

    }

    public static void Start()
    {
        CompletableFuture.supplyAsync(Entry::StartAsync);
    }

    private static JVoid StartAsync()
    {
        WinPeriod.Init();

        MongoRegister.Init();

        World.Instance().AddSingleton(IdGenerator.class);

        return JVoid.INSTANCE;
    }
}
