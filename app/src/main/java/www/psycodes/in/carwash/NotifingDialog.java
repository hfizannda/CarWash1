package www.psycodes.in.carwash;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class NotifingDialog extends Dialog  {

    private Activity activity;
    private CheckBox checkBox;

    NotifingDialog( Activity context) {
        super(context);
        this.activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notifing_dialog);

        Button send = findViewById(R.id.send_notification);
        Button cancle = findViewById(R.id.cancle_notification);
        checkBox = findViewById(R.id.checkbox);


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(checkBox.isChecked()) {
                        EditText msg = findViewById(R.id.message);
                        msg.setText(activity.getString(R.string.car_ready));
                        EditText hours = findViewById(R.id.notification_hour);
                        EditText min = findViewById(R.id.notification_min);
                        hours.setVisibility(View.INVISIBLE);
                        min.setVisibility(View.INVISIBLE);
                        onStart();
                    }else{
                        EditText msg = findViewById(R.id.message);
                        msg.setText(activity.getString(R.string.car_wash_notification));
                        EditText hours = findViewById(R.id.notification_hour);
                        EditText min = findViewById(R.id.notification_min);
                        hours.setVisibility(View.VISIBLE);
                        min.setVisibility(View.VISIBLE);
                        onStart();
                    }
                }

        });


        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //EditText num = findViewById(R.id.notification_number);
                //String[] phoneNumber ={"8618974882","8861851079","9731327628","9011603079","7795481747","8660651437","8197105392","9902480539","8660516183"};// num.getText().toString().trim();
               // for (int i=0;i<phoneNumber.length;i++) {
               //phone here
                String phoneNumber = "";
                    String message;
                    EditText hours = findViewById(R.id.notification_hour);
                    EditText min = findViewById(R.id.notification_min);
                    EditText msg = findViewById(R.id.message);

                    if (checkBox.isChecked()) {
                        message = msg.getText().toString().trim() + "\nRegards,\nCarWallet";
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNumber, "CarWallet", message, null, null);
                        Toast.makeText(activity, "message sent", Toast.LENGTH_SHORT).show();
                        hide();

                    } else {
                        message = msg.getText().toString().trim() +" "+ hours.getText().toString().trim() + "hrs and " + min.getText().toString().trim() + "mins\nRegards,\nCarWallet";
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNumber, "CarWallet", message, null, null);
                        Toast.makeText(activity, "message sent", Toast.LENGTH_SHORT).show();
                        hide();

                    }

                }
            //}
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });


    }



}
