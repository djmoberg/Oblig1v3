package dat153.hvl.no.oblig1v3;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        setNames();
    }

    public void setNames() {
        ListView lv = (ListView) findViewById(R.id.listView);
        ArrayList names = ((GlobalClass) this.getApplication()).getNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        lv.setAdapter(adapter);
    }
}
