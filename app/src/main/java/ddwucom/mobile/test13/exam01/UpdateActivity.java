package ddwucom.mobile.test13.exam01;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText etId;
    EditText etFood;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etId = findViewById(R.id.etUpdateId);
        etFood = findViewById(R.id.etUpdateFood);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getReadableDatabase();

        switch (v.getId()) {
            case R.id.btnUpdateFood:

                ContentValues row = new ContentValues();
                String etFood2 = etFood.getText().toString();

                row.put("food", etFood2);
                String whereClause = "_id=?";
                String[] whereArgs = new String[]{etId.getText().toString()};

                myDB.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);
                break;

            case R.id.btnUpdateCancel:
                break;
        }
        myDbHelper.close();
        finish();
    }
}
