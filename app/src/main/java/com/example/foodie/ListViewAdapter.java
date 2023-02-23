package com.example.foodie;
/*
        AUTHORS

        S.C.R FERNANDO AS2019918
        H.R.Ranaweera  AS2019950

*/
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;


    // The ListViewAdapter Constructor
    public ListViewAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.list_row, items);
        this.context = context;
        list = items;
    }

    // The method we override to provide our own layout for each View (row) in the ListView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.list_row, null);

            TextView foodName = convertView.findViewById(R.id.foodName);

            TextView foodQty =convertView.findViewById(R.id.foodQty);

            TextView netWeight=convertView.findViewById(R.id.netWeight);

            TextView manufacture=convertView.findViewById(R.id.manufacture);

            ImageView remove = convertView.findViewById(R.id.remove);

            //split the received text
            String[] arrayOfSplitString = list.get(position).split(",");
            foodName.setText(arrayOfSplitString[0]);
            foodQty.setText(arrayOfSplitString[1]);
            manufacture.setText(arrayOfSplitString[2]);
            netWeight.setText(arrayOfSplitString[3]+"g");


            // Listeners for duplicating and removing an item.They use the static removeItem and addItem methods created in MainActivity.
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] arrayOfSplitString = list.get(position).split(",");
                    MainActivity.removeItem(position);
                }
            });
        }
        return convertView;
    }
}



