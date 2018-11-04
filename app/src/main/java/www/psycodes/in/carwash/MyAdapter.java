package www.psycodes.in.carwash;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


class MyAdapter extends ArrayAdapter {

     MyAdapter(Profile profile, ArrayList<String[]> values) {
        super(profile,R.layout.car_details_list,values);



    }


    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

         if(convertView == null) {

             LayoutInflater inflater = LayoutInflater.from(getContext());

             View view = inflater.inflate(R.layout.car_details_list, parent, false);

             String[] car_details;
             car_details = (String[]) getItem(position);

             TextView n = view.findViewById(R.id.car_number);
             TextView name = view.findViewById(R.id.car_name);
             TextView plate = view.findViewById(R.id.car_number_plate);
             TextView manu = view.findViewById(R.id.car_manufacturer);
             Button remove = view.findViewById(R.id.remome_car);


             remove.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Profile.carDetails.remove(position);
                     MyAdapter.this.notifyDataSetChanged();
                 }
             });


             assert car_details != null;
             n.setText(car_details[0]);
             name.setText(car_details[1]);
             plate.setText(car_details[2]);
             manu.setText(car_details[3]);

             return view;
         }

         return convertView;
    }
}
