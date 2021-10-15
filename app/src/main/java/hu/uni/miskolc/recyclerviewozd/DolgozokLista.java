package hu.uni.miskolc.recyclerviewozd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hu.uni.miskolc.recyclerviewozd.recyclerview.DolgozokListaFragment;

public class DolgozokLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dolgozok_lista_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DolgozokListaFragment.newInstance())
                    .commitNow();
        }
    }
}