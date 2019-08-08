package com.example.lista;

import android.os.Build;
import android.os.Bundle;

import com.example.lista.lista.ListaCarrosFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.transition.Explode;
import android.transition.Fade;
import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button lista;
    private Button Calendario;
    private DataFragment data;
    private ListaCarrosFragment listCar;
    private VisualizacaoFragment visul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Explode trans1 = new Explode();
            trans1.setDuration(3000);
            Fade trans2 = new Fade();
            trans2.setDuration(3000);

            getWindow().setExitTransition(trans1);
            getWindow().setReenterTransition(trans2);

        }*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        data = new DataFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, data);
        transaction.commit();

        lista = findViewById(R.id.btnLista);

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // if (data.getLockTela() == 1) {
                    irLista();
            //    }else {
         //           Toast.makeText(getApplicationContext(), "Primeiro escolha as datas", Toast.LENGTH_SHORT).show();
        //       }
            }
        });


        Calendario = findViewById(R.id.btnCalendario);
        Calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irData();
            }
        });

    }

   /* @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "a", Toast.LENGTH_SHORT).show();*/


   public void irLista(){
        listCar = new ListaCarrosFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, listCar);
        transaction.commit();
    }


    public void irData(){
        data = new DataFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, data);
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
