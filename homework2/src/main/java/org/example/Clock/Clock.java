package org.example.Clock;

public class Clock implements Readable {
    private int hour;
    private int minute;
    private int sec;

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return this.hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getSec() {
        return this.sec;
    }

    public void tick() {
        sec++;
        if (sec >= 60) {
            minute++;
            sec = 0;
        }
        if (minute >= 60) {
            hour++;
            minute = 0;
        }
        if (hour >= 24) {
            hour = 0;
        }
    }


    @Override
    public void readTime() {
        System.out.println(String.format("%02d:%02d:%02d", this.hour, this.minute, this.sec));
    }
}
