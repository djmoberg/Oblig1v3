package dat153.hvl.no.oblig1v3;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class LearningActivity extends AppCompatActivity {

    private String name = "";
    private  int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        name = randomName();
        score = 0;

        setImage(name);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private String randomName() {
        String name;
        final ArrayList<String> names = ((GlobalClass) this.getApplication()).getNames();
        int min = 0;
        int max = names.size() - 1;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        name = names.get(randomNum);

        if (this.name.equals(name)) {
            return randomName();
        }

        return name;
    }

    private void setImage(String name) {
        ImageView iv = (ImageView) findViewById(R.id.imageView3);
        Uri uri = ((GlobalClass) this.getApplication()).getUri(name);

        InputStream is = null;
        try {
            is = getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bm = BitmapFactory.decodeStream(is);
        iv.setImageBitmap(bm);
    }

    public void checkAnswerOnClick(View v) {
        EditText text = (EditText) findViewById(R.id.editText);
        if (name.toLowerCase().equals(text.getText().toString().toLowerCase())) {
            Toast.makeText(LearningActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        } else {
            Toast.makeText(LearningActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
            score--;
        }

        text.setText("");
        name = randomName();
        setImage(name);

        /*SharedPreferences prefs = getApplication().getSharedPreferences("appData", MODE_PRIVATE);
        prefs.edit().putInt("score", score).apply();*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(LearningActivity.this, "Final Score: " + String.valueOf(score), Toast.LENGTH_SHORT).show();
    }

}
