package hu.uni.miskolc.recyclerviewozd;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.widget.TextView;

import hu.uni.miskolc.recyclerviewozd.model.Dolgozo;
import hu.uni.miskolc.recyclerviewozd.service.DolgozoService;

public class DolgozoDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dolgozo_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Dolgozo dolgozo = (Dolgozo) getIntent().getSerializableExtra("selected");
        TextView idertek = findViewById(R.id.idertek);
        TextView keresztnevertek = findViewById(R.id.keresztnevErtek);
        TextView vezeteknevertek = findViewById(R.id.vezeteknevErtek);
        TextView fizetesErtek = findViewById(R.id.fizetesErtek);
        idertek.setText(String.valueOf(dolgozo.getId()));
        keresztnevertek.setText(dolgozo.getKeresztNev());
        vezeteknevertek.setText(dolgozo.getVezetekNev());
        fizetesErtek.setText(String.valueOf(dolgozo.getFizetes()));
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //DolgozoDetails.this.finish();
                NavUtils.navigateUpFromSameTask(DolgozoDetails.this);
            }
        };
        getOnBackPressedDispatcher().addCallback(this,callback);
    }
}