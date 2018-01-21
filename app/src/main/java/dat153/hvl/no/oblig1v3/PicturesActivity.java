package dat153.hvl.no.oblig1v3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
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

            Uri uri = ((GlobalClass) this.getApplication()).getUri(names.get(i));

            InputStream is = null;
            try {
                is = getApplicationContext().getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bm = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bm);

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
