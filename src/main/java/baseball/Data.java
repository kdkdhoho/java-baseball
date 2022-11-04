package baseball;

import java.time.LocalDateTime;

public class Data {

    private LocalDateTime tryDate;
    private int tryCount;

    public Data(LocalDateTime tryDate, int tryCount) {
        this.tryDate = tryDate;
        this.tryCount = tryCount;
    }

    public LocalDateTime getTryDate() {
        return tryDate;
    }

    public int getTryCount() {
        return tryCount;
    }
}