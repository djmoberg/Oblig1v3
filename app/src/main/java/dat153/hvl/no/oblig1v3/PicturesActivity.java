package dat153.hvl.no.oblig1v3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PicturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        addPictures();
    }

    private void addPictures() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout2);
        final ArrayList<String> names = ((GlobalClass) this.getApplication()).getNames();


        for (int i = 0; i < names.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(600, 600));
            imageView.setImageBitmap(((GlobalClass) this.getApplication()).getBitmap(names.get(i)));

            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PicturesActivity.this, ShowAnswerActivity.class);
                    intent.putExtra("name", names.get(finalI));
                    startActivity(intent);
                }
            });

            layout.addView(imageView);
        }
    }
}
