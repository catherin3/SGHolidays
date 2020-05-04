package sg.edu.rp.c346.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday>holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        lv = (ListView) this.findViewById(R.id.ivHoliday);


        final ArrayList<Holiday> holiday = new ArrayList<Holiday>();
        Intent i = getIntent();
        String category = i.getStringExtra("cat");
        tvName.setText(category);

        if(category.equalsIgnoreCase("secular")) {
            holiday.add(new Holiday("New Year's Day", "1 Jan 2017", "New Year's Day"));
            holiday.add(new Holiday("Labour Day", "1 May 2017", "Labour Day"));
        }else{
            holiday.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "Chinese New Year"));
            holiday.add(new Holiday("Good Friday", "14 April 2017", "Good Friday"));
        }

        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedholiday = holiday.get(position);
                Toast.makeText(SecondActivity.this, selectedholiday.getName()+"\n"+selectedholiday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
