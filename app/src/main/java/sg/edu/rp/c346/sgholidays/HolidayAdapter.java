package sg.edu.rp.c346.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tvHoliday;
    private TextView tvDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource,objects);
        // Store the ArrayList of objects passed to this adapter
        this.holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is called every time for every row
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        // Get the TextView object
        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);
        //Get the TextView object
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(pos);
        // Set the TextView to show the food

        tvHoliday.setText(currentHoliday.getName());
        // Set the image to star or nostar accordingly
        tvDate.setText(currentHoliday.getDate());
        if (currentHoliday.getName().equals("New Year's Day")) {
            ivHoliday.setImageResource(R.drawable.newyear);
        } else if (currentHoliday.getName().equals("Labour Day")) {
            ivHoliday.setImageResource(R.drawable.labourday);
        } else if (currentHoliday.getName().equals("Chinese New Year"))
            ivHoliday.setImageResource(R.drawable.cny);
        else {
            ivHoliday.setImageResource(R.drawable.cross);
        }
            return rowView;
        }

}

