package www.psycodes.in.carwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Rewards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        String[] reward = {"KA-19EB-4413","2000","10","28/12/2018","1:10 am"};

        ArrayAdapter arrayAdapter = new RewardAdapter(this,reward);
        ListView rewardList = findViewById(R.id.reward_list);
        rewardList.setAdapter(arrayAdapter);
    }

    public void backButtonHandler(View view) {
        finish();
    }
}
