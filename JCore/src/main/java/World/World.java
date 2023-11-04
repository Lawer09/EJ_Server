package World;

import Collections.JMap;
import Collections.JStack;

import java.lang.reflect.InvocationTargetException;

public class World {

    private static World instance = new World();

    public static World Instance()
    {
        return  instance;
    }

    //管理继承了ISingletonReverseDispose的对象类型
    private final JStack<Class<?>> stack = new JStack<>();
    private final JMap<Class<?>,ASingleton> singletons = new JMap<>();

    private World()
    {

    }

    public void Dispose()
    {
        instance = null;

        synchronized (this){
            Class<?> type = this.stack.pop();
            ASingleton singleton = this.singletons.Remove(type);
            if(singleton !=null)
            {
                singleton.Dispose();
            }
            this.singletons.forEach((k,v)->{
                v.Dispose();
            });

        }
    }

    //允许在多线程使用，将单例对象加入
    public void AddSingleton(ASingleton singleton)
    {
        synchronized (this)
        {
            Class<?> type = singleton.getClass();
            //如果单例对象继承了ISingletonReverseDispose，则将对象加入stack中
            if(singleton instanceof ISingletonReverseDispose)
            {
                this.stack.Push(type);
            }
            singletons.Put(type, singleton);
        }
        singleton.Register();
    }

    //加入的单例必须继承ASingleton,ISingletonAwake..
    public <T extends ISingletonAwake> T AddSingleton(Class<T> type){

        try {
            T t = type.getDeclaredConstructor().newInstance();
            t.Awake();
            AddSingleton((ASingleton) t);
            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <A, T extends ISingletonAwakeOne<A>> T AddSingleton(Class<T> type,A a){
        try {
            T t = type.getDeclaredConstructor().newInstance();
            t.Awake(a);
            AddSingleton((ASingleton) t);
            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <A,B, T extends ISingletonAwakeTwo<A,B>> T AddSingleton(Class<T> type,A a, B b){
        try {
            T t = type.getDeclaredConstructor().newInstance();
            t.Awake(a,b);
            AddSingleton((ASingleton) t);
            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <A,B,C, T extends ISingletonAwakeThree<A,B,C>> T AddSingleton(Class<T> type,A a, B b,C c){
        try {
            T t = type.getDeclaredConstructor().newInstance();
            t.Awake(a,b,c);
            AddSingleton((ASingleton) t);
            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
