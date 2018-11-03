package www.psycodes.in.carwash;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rewardpage extends AppCompatActivity {
  EditText amount,rewardper;
  Button reset,calculate,reward;
  TextView percentage,prerecrd,rewardans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewardpage);
        amount =findViewById(R.id.amount);
        rewardper=findViewById(R.id.Rewardpercentage);
        rewardans=findViewById(R.id.rewardans);
        reset=findViewById(R.id.reset_btn);
        calculate=findViewById(R.id.calulate_btn);
        reward=findViewById(R.id.Reward_btn);
        prerecrd = findViewById(R.id.previous_record);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setHint(R.string.amount);
                rewardper.setHint(R.string.reward_percentage);
                rewardans.setText("");
                amount.setText("");

                rewardans.setVisibility(View.INVISIBLE);
            }
        });
        prerecrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Rewardpage.this, "Previous Records:", Toast.LENGTH_SHORT).show();
            }
        });
        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Rewardpage.this, "Reward Successfful", Toast.LENGTH_SHORT).show();
            }
        });
calculate.setOnClickListener(new View.OnClickListener() {
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        String amot = amount.getText().toString();
        String rew = rewardper.getText().toString();
        if(check(amount)|| check(rewardper) ) {

            int amt = Integer.parseInt(amot);
            Log.i("Black", "" + amt);
            int rewpr = Integer.parseInt(rew);
            Log.i("Black", "" + rewpr);
            double per = (rewpr / 100.0) * amt;
            Log.i("Black", "" + per);
            rewardans.setText(getString(R.string.earned)+" " + (int)per + " "+getString(R.string.points));
            rewardans.setTextColor(Color.YELLOW);
            rewardans.setVisibility(View.VISIBLE);
        }
    }
});
    }

    boolean check (EditText editText){

        if(editText.getText().toString().isEmpty()){
            editText.setError("Cant be empty");
            return false;
        }
        return true;
    }

}
