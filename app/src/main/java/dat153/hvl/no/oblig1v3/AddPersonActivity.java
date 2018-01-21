package dat153.hvl.no.oblig1v3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddPersonActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 1;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);


    }

    public void onClickAddPicture(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
//        Intent getIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//        getIntent.setType("image/*");
//
//        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        pickIntent.setType("image/*");
//
//        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
//        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
//
//        startActivityForResult(chooserIntent, SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                selectedImageUri = data.getData();
//                selectedImagePath = getPath(selectedImageUri);

//                InputStream is = null;
//                try {
//                    is = getApplicationContext().getContentResolver().openInputStream(selectedImageUri);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
                ImageView iv = (ImageView) findViewById(R.id.imageViewAddPerson);
//                iv.setImageBitmap(bitmap);
                iv.setImageURI(selectedImageUri);

            }
        }
    }

    public void onClickSave(View v) {
        EditText et = (EditText) findViewById(R.id.editText2);

        if (!et.getText().toString().equals("") && selectedImageUri != null) {
            ((GlobalClass) this.getApplication()).addNameUri(et.getText().toString(), selectedImageUri);

            Toast.makeText(AddPersonActivity.this, "Saved", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(AddPersonActivity.this, "Missing name or image", Toast.LENGTH_SHORT).show();
        }

    }
}
