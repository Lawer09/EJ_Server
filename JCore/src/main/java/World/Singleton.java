package World;


import MObject.DisposeObject;




public abstract class Singleton<T extends Singleton<T>> extends ASingleton{


    private boolean isDisposed;

    private static Singleton<?> instance;

    public static Singleton<?> Instance()
    {
        return instance;
    }


    @Override
    void Register() {
        instance = this;
    }





}
