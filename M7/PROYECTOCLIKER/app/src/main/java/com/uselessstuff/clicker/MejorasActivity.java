package com.uselessstuff.clicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class MejorasActivity extends AppCompatActivity {

    private View parent_view;
    private RecyclerView recyclerView;
    private AdapterListAnimation mAdapter;
    private int puntos;
    private int bonus;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejoras);
        parent_view = findViewById(android.R.id.content);
        //puntos = getIntent().getIntExtra("puntos",0);
        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar1);
        toolbar.setNavigationIcon(R.drawable.bluegem);
        toolbar.setTitle("puntos: "+MainActivity.puntos);
        //getSupportActionBar().setTitle("puntos: "+puntos);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Tools.setSystemBarColor(this);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setHasFixedSize(true);
        final List<Arma> items = new ArrayList<>();
        items.add(new Arma("arma1",10,20,getString(R.string.descripcionArma1),R.drawable.arma1));
        items.add(new Arma("arma2",20,40,"Descripción arma2",R.drawable.arma2));
        items.add(new Arma("arma3",30,80,"Descripción arma3",R.drawable.arma3));
        items.add(new Arma("arma4",40,160,"Descripción arma4",R.drawable.arma4));
        items.add(new Arma("arma5",50,320,"Descripción arma5",R.drawable.arma5));
        items.add(new Arma("arma6",60,640,"Descripción arma6",R.drawable.arma6));
        items.add(new Arma("arma7",70,1280,"Descripción arma7",R.drawable.arma7));

        //set data and list adapter
        mAdapter = new AdapterListAnimation(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListAnimation.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Arma obj, int position) {
                if(obj.getCoste()<=MainActivity.puntos){
                    MainActivity.bonus =MainActivity.bonus+obj.getDanyo();
                    MainActivity.puntos=MainActivity.puntos-obj.getCoste();
                    toolbar.setTitle("puntos: "+MainActivity.puntos);
                    items.remove(position);
                    mAdapter = new AdapterListAnimation(MejorasActivity.this, items);
                    recyclerView.setAdapter(mAdapter);
                }else {
                    Toast.makeText(MejorasActivity.this, "te falta  " + (obj.getCoste()+MainActivity.puntos) + " puntos", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MejorasActivity.this, "Item " + obj.getNombre() + " Clicado", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
