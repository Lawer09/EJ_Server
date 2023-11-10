import Loader.CodeLoader;
import World.Module.Fiber.FiberManager;
import World.Module.Log.Logger;
import World.Module.Log.NLog;
import World.Module.Options.CLParser;
import World.Module.Options.JOptions;
import World.Module.TimeInfo.TimeInfo;
import World.World;
import org.apache.commons.cli.Options;

import java.sql.Time;

public class Init {

    public void Start(String[] args)
    {
        //TODO 处理程序域下未捕获的异常

        //解析命令行参数并创建Option，将Option对象加入World
        CLParser<JOptions> clParser = new CLParser<>();

        //临时初始化
        JOptions jOptions = new JOptions();
        jOptions.Register();

        clParser.Create((JOptions) JOptions.GetInstance(), args)
                .WithNoParsed(error->{
                    throw new RuntimeException("命令行格式错误!"+error);
                })
                .WithParsed(o -> {
                    System.out.print(o.appType);
                    World.Instance().AddSingleton(o);
                }).Parse();

        NLog nLog = new NLog(jOptions.appType.name(), jOptions.process, 0, "../Config/NLog/NLog.config");
        World.Instance().AddSingleton(Logger.class).SetLog(nLog);
        //TODO ETTask

        World.Instance().AddSingleton(TimeInfo.class);
        World.Instance().AddSingleton(FiberManager.class);
        World.Instance().AddSingleton(CodeLoader.class);
    }

    public void Update()
    {
        ((TimeInfo)TimeInfo.GetInstance()).Update();
        ((FiberManager)FiberManager.GetInstance()).Update();
    }

    public void LateUpdate()
    {
        ((FiberManager)FiberManager.GetInstance()).LateUpdate();
    }
}
