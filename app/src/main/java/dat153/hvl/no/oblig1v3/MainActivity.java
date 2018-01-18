package dat153.hvl.no.oblig1v3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDefaultData();
    }

    public void onClickNames(View v) {
        startActivity(new Intent(this, NamesActivity.class));
    }

    public void onClickPictures(View v) {
        startActivity(new Intent(this, PicturesActivity.class));
    }

    public void onClickLearning(View v) {
        startActivity(new Intent(this, LearningActivity.class));
    }

    private void setDefaultData() {
        ((GlobalClass) this.getApplication()).addName("Daniel", "android.resource://dat153.hvl.no.oblig1v3/drawable/daniel");
        ((GlobalClass) this.getApplication()).addName("Oskar", "android.resource://dat153.hvl.no.oblig1v3/drawable/oskar");
        ((GlobalClass) this.getApplication()).addName("Abdella", "android.resource://dat153.hvl.no.oblig1v3/drawable/abdella");
    }
}
