package www.psycodes.in.carwash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class RewardAdapter extends ArrayAdapter {
    RewardAdapter(Context context, Object[] objects) {
        super(context, R.layout.reward_list, objects);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view = inflater.inflate(R.layout.reward_list,parent,false);

        return view;
    }
}
