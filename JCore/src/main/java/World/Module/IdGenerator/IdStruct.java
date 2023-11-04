package World.Module.IdGenerator;

public class IdStruct {

    public short Process;
    public int Time;
    public int Value;

    public long ToLong() {
        long result = 0;
        result |= this.Process;
        result <<= 14;
        result |= this.Time;
        result <<= 30;
        result |= this.Value;
        return result;
    }

    public IdStruct(int time, short process, int value) {
        this.Process = process;
        this.Time = time;
        this.Value = value;
    }

    public IdStruct(long id)
    {
        long result = id;
        this.Value = (short) (result & IdGenerator.Mask20bit);
        result >>= 20;
        this.Time = (int) result & IdGenerator.Mask30bit;
        result >>= 30;
        this.Process = (short) (result & IdGenerator.Mask14bit);
    }

}
