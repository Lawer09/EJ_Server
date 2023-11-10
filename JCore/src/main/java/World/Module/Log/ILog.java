package World.Module.Log;

public interface ILog {

    void Trace(String message);
    void Warning(String message);
    void Info(String message);
    void Debug(String message);
    void Error(String message);
    void Error(Exception e);

}
