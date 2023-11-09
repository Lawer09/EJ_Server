import World.Module.Log.Log;
import World.Module.Options.CLParser;
import World.Module.Options.JOptions;
import World.World;

public class Init {


    public void Start(String[] args)
    {
        //TODO 处理程序域下未捕获的异常

        //解析命令行参数并创建Option，将Option对象加入World
        CLParser<JOptions> clParser = new CLParser<>();

        //临时初始化
        new JOptions().Register();

        clParser.Create((JOptions) JOptions.GetInstance(), args)
                .WithNoParsed(error->{
                    throw new RuntimeException("命令行格式错误!"+error);
                })
                .WithParsed(o -> {
                    System.out.print(o.appType);
                    World.Instance().AddSingleton(o);
                }).Parse();

    }

    public void Update()
    {

    }

    public void LateUpdate()
    {

    }
}
