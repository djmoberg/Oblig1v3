package dat153.hvl.no.oblig1v3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ShowAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);

        showAnswer();
    }

    private void showAnswer() {
        String name = getIntent().getStringExtra("name");

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(name);

        Uri uri = ((GlobalClass) this.getApplication()).getUri(name);

        InputStream is = null;
        try {
            is = getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(bitmap);
    }

}
