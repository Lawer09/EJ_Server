import World.Module.Log.Log;

public class Program {


    public static void main(String[] args) {

        Entry.Init();

        Init init = new Init();
        init.Start();

        while (true)
        {
            try {
                Thread.sleep(1);

                init.Update();
                init.LateUpdate();

            } catch (InterruptedException e) {
                //java中调用Thread.sleep方法使得系统进入睡眠时可以被其他线程通过调用interrupt()方法来中断，从而触发InterruptedException异常
                throw new RuntimeException(e);
            } catch (Exception e)
            {
                Log.Error(e);
            }
        }
    }

}
