package World;

public abstract class Singleton extends ASingleton {

    private boolean isDisposed;

    private static Singleton instance;

    public static Singleton GetInstance()
    {
        return instance;
    }

    private static void SetInstance(Singleton instance)
    {
    }

    @Override
    public void Register() {
        instance = this;
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
