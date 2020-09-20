package com.example.trainning_proj.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainning_proj.Exchange_Rates;
import com.example.trainning_proj.R;
import com.example.trainning_proj.Setting.Setting;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView_all_place  ,recyclerView_top_place ,recyclerView_by_from_egypt ;
    ArrayList<Data> arrayList = new ArrayList<>();
    DataAdapter adapter ;
    ImageButton imageButton_setting ;

    private DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        //////////////Navigation_Bar//////////////

        Toolbar toolbar=findViewById(R.id.toolBAr);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.layout_drawer);
        NavigationView navigationView=findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ////////////////////////////////////////////////////////



        recyclerView_all_place = findViewById(R.id.recycle_view_all_place);
        recyclerView_top_place = findViewById(R.id.recycle_view_top_place);
        recyclerView_by_from_egypt = findViewById(R.id.recycle_view_by_from_Egypt);

        imageButton_setting = findViewById(R.id.img_btn_setting);

        /// function imageButton setting to open setting



        /// function set data in recycle view
        set_data_recycle();

    }
    //////////Nav_Bar////////

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.menu_home:
            {
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    super.onBackPressed();
                }
                break;
            }
            case R.id.menu_settings:
            {
               startActivity(new Intent(Home.this, Setting.class));
               break;
            }
            case R.id.menu_currency:
            {
                startActivity(new Intent(Home.this, Exchange_Rates.class));
                break;
            }
            case R.id.menu_logOut:
            {
                Toast.makeText(getApplicationContext(),"Logging Out..  ",Toast.LENGTH_LONG).show();
                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }




    /////////////////////////

    private void open_setting() {

        imageButton_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open setting
                Intent intent = new Intent(Home.this, Setting.class);
                startActivity(intent);

            }
        });
    }

    private void set_data_recycle() {

        // add item
        arrayList.add(new Data(R.drawable.pyramids, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));

        // object from DataAdapter send (context , array from data)
        adapter = new DataAdapter(Home.this, arrayList);
        //recyclerView.setHasFixedSize(true);

        recyclerView_all_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_all_place.setAdapter(adapter);

        recyclerView_top_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_place.setAdapter(adapter);

        recyclerView_by_from_egypt.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_by_from_egypt.setAdapter(adapter);

    }

}