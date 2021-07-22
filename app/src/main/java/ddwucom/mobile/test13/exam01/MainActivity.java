package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;
    final int REQ_CODE = 100;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {

        SQLiteDatabase myDB = myDbHelper.getReadableDatabase();
        ContentValues row;
        String whereClause;
        String[] whereArgs;

        switch(v.getId()) {
            case R.id.btnSelect:
                String selection = "food=?";
                String[] selectArgs = new String[] {"된장찌개"};
                Cursor cursor =
                        myDB.query(FoodDBHelper.TABLE_NAME, null, null,
                                null, null, null, null, null);

                String result ="";
                while (cursor.moveToNext()) {
                    result += cursor.getInt (cursor.getColumnIndex(FoodDBHelper.COL_ID)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION)) + "\n";
                }
                tvDisplay.setText(result);
                cursor.close();
                break;

            case R.id.btnAdd:
                intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;

            case R.id.btnUpdate:
                intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
                break;

            case R.id.btnRemove:
                intent = new Intent(MainActivity.this, RemoveActivity.class);
                startActivity(intent);
                break;
        }

        myDbHelper.close();
    }

}
