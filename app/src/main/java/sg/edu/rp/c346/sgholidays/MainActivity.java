package sg.edu.rp.c346.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvYear);


        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");



        aa= new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start the SecondActivity
                String selectedName = al.get(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("cat",selectedName );
                startActivity(intent);

            }
        });
    }
}
