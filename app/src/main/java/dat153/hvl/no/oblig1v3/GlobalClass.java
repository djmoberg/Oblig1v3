package dat153.hvl.no.oblig1v3;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Dan2016 on 17.01.2018.
 */

public class GlobalClass extends Application {
    private ArrayList<String> names = new ArrayList<>();

    public ArrayList<String> getNames() {
        return names;
    }

    public void addName(String name) {
        names.add(name);
    }
}
