package www.psycodes.in.carwash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    static ArrayList<String[]> carDetails = new ArrayList<>();
    final int SEND_SMS_REQUEST_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String[] _1= {"2.","Santro","KA-19EB-4020","HYUNDAI"};
        String[] _2 = {"1.","Elantra","KA-19EB-4020","HYUNDAI"};
        String[] _3 = {"3.","Alto 800","KA-19EB-4020","MARUTHI"};
        carDetails.add(_2);
        carDetails.add(_1);
        carDetails.add(_3);
        ListView carList = findViewById(R.id.pf_car_list);
        ArrayAdapter adapter = new MyAdapter(this,carDetails);
        carList.setAdapter(adapter);
    }

    public void backButtonHandler(View view) {
        finish();
    }

    public void notifyHandler(View view) {
          if(checkPermission()) {
              NotifingDialog notifingDialog = new NotifingDialog(this);
              notifingDialog.show();
          }else {
              ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_REQUEST_CODE);
          }
    }

    private boolean checkPermission(){
        int check = ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS);
        return check == PackageManager.PERMISSION_GRANTED;
    }

    public void addCarInfoHandler(View view) {
//
//        startActivity(new Intent(Profile.this,WebView.class));
   }


    public void rewardHandler(View view) {
        startActivity(new Intent(Profile.this,Rewards.class));
    }
}
