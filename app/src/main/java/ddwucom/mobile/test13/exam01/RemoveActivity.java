package ddwucom.mobile.test13.exam01;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RemoveActivity extends AppCompatActivity {

    EditText etFood;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        etFood = findViewById(R.id.etRemoveFood);

        myDbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v){
        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnRemoveFood:
                String etFood2 = etFood.getText().toString();

                String whereClause = "food=?";
                String[] whereArgs = new String[]{etFood2};

                myDB.delete (FoodDBHelper.TABLE_NAME, whereClause, whereArgs);

                break;
            case R.id.btnRemoveCancel:
                break;
        }
        myDbHelper.close();
        finish();
    }
}
