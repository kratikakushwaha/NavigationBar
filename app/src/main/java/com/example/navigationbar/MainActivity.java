package com.example.navigationbar;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageView imageView;
    Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView=findViewById(R.id.navigation);
        imageView=navigationView.getHeaderView(0).findViewById(R.id.imageview);
        navigationView.setNavigationItemSelectedListener(this);

    }


           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               int itemId=menuItem.getItemId();

                if (itemId == R.id.mail)
                {
                  frag = new Fragment1();

               }
               if (itemId == R.id.send)
               {
                    frag = new Fragment2();
                }
                 if (itemId == R.id.share)
                {
                   frag = new Fragment3();
                }

               if(itemId==R.id.change)
               {
             imageView.setImageResource(R.drawable.ic_settings_black_24dp);

                 }


             //  Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();


               if (frag != null)
               {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag);
                    transaction.commit();


                }
               drawerLayout.closeDrawer(GravityCompat.START);

               return false;
            }


   }

