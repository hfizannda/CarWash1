package www.psycodes.in.carwash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button new_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        new_button = findViewById(R.id.new_button);

    }
    public void next(View view) {
     Intent intent = new Intent(this,new_customer.class);
     startActivity(intent);
    }

    public void search(View view) {
        Intent intent = new Intent(this, search_customer.class);
    }
}
