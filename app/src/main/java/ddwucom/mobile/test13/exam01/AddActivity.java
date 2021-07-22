package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAddFood:

                String etFood2 = etFood.getText().toString();
                String etNation2 = etNation.getText().toString();

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, etFood2);
                row.put(FoodDBHelper.COL_NATION, etNation2);
                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);
                break;

            case R.id.btnAddCancel:
                break;
        }
        myDbHelper.close();
        finish();
    }
}
