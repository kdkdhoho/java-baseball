package baseball;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Data> database = new ArrayList<>();

    public void addData(Data data) {
        database.add(data);
    }

    public Data getData(Data data) {
        if(database.contains(data)) {
            return database.get(database.indexOf(data));
        }
        return null;
    }

    public void modifyData(Data existData, Data newData) {
        if(database.contains(existData)) {
            Data data = database.get(database.indexOf(existData));
            data.modifyTryData(newData.getTryDate());
            data.modifyTryCount(newData.getTryCount());
        }
    }

    public void removeData(Data data) {
        if (database.contains(data)) {
            database.remove(data);
        }
    }
}
