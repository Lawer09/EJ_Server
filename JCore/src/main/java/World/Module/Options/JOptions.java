package World.Module.Options;

import World.Singleton;

public class JOptions extends Singleton {

    @JOption(Opt = "AppType", Required = false, Description = "AppType enum")
    public AppType appType =  AppType.Server;

    @JOption(Opt = "StartConfig", Required = false)
    public String startConfig = "StartConfig/Localhost";

    @JOption(Opt = "Process", Required = false)
    public int process = 1;

    @JOption(Opt = "Develop", Required = false, Description = "develop mode, 0正式 1开发 2压测")
    public int develop = 0;

    @JOption(Opt = "LogLevel", Required = false)
    public int logLevel = 0;

    @JOption(Opt = "Console", Required = false)
    public int Console = 0;

}
