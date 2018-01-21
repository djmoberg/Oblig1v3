package dat153.hvl.no.oblig1v3;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dan2016 on 17.01.2018.
 */

public class GlobalClass extends Application {
    private HashMap<String, Uri> names = new HashMap<>();

    public ArrayList<String> getNames() {
        ArrayList<String> nameArray = new ArrayList<>();
        Set set = names.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            nameArray.add(mentry.getKey().toString());
        }
        return nameArray;
    }

    public void addName(String name, String uriString) {
        Uri uri = Uri.parse(uriString);
        names.put(name, uri);
    }

    public void addNameUri(String name, Uri uri) {
        names.put(name, uri);
    }

    public Uri getUri(String name) {
        return names.get(name);
    }

/*    public Bitmap getBitmap(String name) {
        Uri uri = getUri(name);

        InputStream is = null;
        try {
            is = getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeStream(is);
    }*/
}
