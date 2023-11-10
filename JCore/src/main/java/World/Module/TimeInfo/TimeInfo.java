package World.Module.TimeInfo;

import World.ISingletonAwake;
import World.Singleton;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

public class TimeInfo extends Singleton implements ISingletonAwake {

    private LocalDateTime dt;
    private LocalDateTime dt1970;

    private int timeZone;

    private long serverMinusClientTime;
    private long frameTime;

    private long GetServerMinusClientTime() {
        return serverMinusClientTime;
    }

    public void SetServerMinusClientTime(long serverMinusClientTime) {
        this.serverMinusClientTime = serverMinusClientTime;
    }

    public long GetFrameTime() {
        return frameTime;
    }

    public void SetFrameTime(long frameTime) {
        this.frameTime = frameTime;
    }

    public int GetTimeZone() {
        return this.timeZone;
    }

    public void SetTimeZone(int timeZone) {
        this.timeZone = timeZone;
        dt = dt1970.plusHours(GetTimeZone());
    }

    @Override
    public void Awake() {
        this.dt1970 = LocalDateTime.of(1970, 1, 1, 0, 0,0);
        this.dt = LocalDateTime.of(1970, 1, 1, 0, 0,0);
        this.SetFrameTime(this.ClientNow());
    }

    public long ClientNow()
    {
        //获取从1970自现在的毫秒数
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli() - dt1970.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public long ServerNow()
    {
        return this.ClientNow() + this.GetServerMinusClientTime();
    }

    public long ClientFrameTime()
    {
        return this.GetFrameTime();
    }

    public long ServerFrameTime()
    {
        return this.GetFrameTime() + this.GetServerMinusClientTime();
    }

    public void Update()
    {
        this.SetFrameTime(this.ClientNow());
    }

    public LocalDateTime ToDateTime(long timeStamp)
    {
        return dt.plusMinutes(timeStamp);
    }


}
