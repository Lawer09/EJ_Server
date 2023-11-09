package World.Module.Options;

public enum AppType {
    Server,
    Watcher, // 每台物理机一个守护进程，用来启动该物理机上的所有进程
    GameTool,
    ExcelExporter,
    Proto2CS,
    BenchmarkClient,
    BenchmarkServer,

    Demo,
    LockStep,
}
