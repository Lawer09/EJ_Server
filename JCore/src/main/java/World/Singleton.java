package World;

public abstract class Singleton extends ASingleton {

    private boolean isDisposed;

    private static Singleton instance;

    public static Singleton GetInstance()
    {
        return instance;
    }

    private static void SetInstance(Singleton singleton)
    {
        instance = singleton;
    }

    @Override
    public void Register() {
        SetInstance(this);
    }

    public boolean IsDisposed(){
        return this.isDisposed;
    }

    protected void Destroy()
    {

    }

    @Override
    public void Dispose()
    {
        if(this.isDisposed)
        {
            return;
        }
        this.isDisposed = true;
        this.Destroy();
        SetInstance(null);
    }
}
