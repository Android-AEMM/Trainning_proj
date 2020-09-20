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
    ArrayList<Data> arrayList_place = new ArrayList<>();
    ArrayList<Data> arrayList_famous_place = new ArrayList<>();

    ArrayList<DataProduct> arrayList_product = new ArrayList<>();

    DataAdapter adapter_place ,adapter_famous_place;
    DataProductAddapter adapter_product;
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

        // add place

        arrayList_place.add(new Data(R.drawable.almothaf_elmasry3, "Egyptian Museum", "The Egyptian Museum in Cairo is one of the largest and most famous museums in the world and is currently located in Tahrir Square in the heart of the Egyptian capital \"Cairo\", while its inception in 1835 in Al-Azbakeya Park and it included a large number of various antiquities, then it was transferred with its contents to the second exhibition hall in the Citadel of Salah al-Din, until he thought The French Egyptologist Auguste Mariette, who was working at the Louvre, opened a museum in which he displays a collection of antiquities on the shore of the Nile at Bulaq, and when these monuments were exposed to the danger of flooding, they were transferred to a special annex in the Khedive Ismail's palace in Giza, then came Egyptologist Gaston Maspero and opened in 1902 During the reign of Khedive Abbas Helmy II, the new building is located in its current location in the heart of Cairo. The museum includes more than 150,000 artifacts, the most important of which are the archaeological collections that were found in the tombs of the kings and the royal entourage of the middle family in Dahshur in 1894, and the museum now houses the greatest archaeological collection in the world that expresses all stages of ancient Egyptian history.","Cairo"));
       // arrayList_place.add(new Data(R.drawable.elfant_ilend1, "item1", "desc1"));
        arrayList_place.add(new Data(R.drawable.gamy, "Agiba plateau", "Wonderful plateau is one of the most important tourist areas in Matrouh and enjoys the interest of visitors to the governorate in the summer to enjoy its unique beach in its beauty at the level of the world, with turquoise waters, bright colors, beauty of nature, and to see the colored rocks and rooms carved into the rocks of the plateau.\n" +
                "Despite its natural features, a wonderful plateau has not yet taken full advantage of it, despite the fact that during the summer season it receives nearly 3 million vacationers.\n" +
                "\n" +
                "\n" +
                "Mustafa and the visitors of Matrouh from restaurants and cafeterias that adhere to the environmental character This will benefit the people of the governorate and provide job opportunities for Matrouh youth.","Marsa matrouh "));

        arrayList_place.add(new Data(R.drawable.mohamed_head, "Ras Mohammed Reserve", "The «Ras Muhammad» reserve in South Sinai is considered the second most important nature reserve in the world over the past 30 years, after Uluru - Kata Park Tjuta, Australia. The Ras Mohammed reserve is located at the confluence of the Gulf of Suez and the Gulf of Aqaba, and the eastern edge of the Ras Mohammed reserve represents a rocky wall with the waters of the Gulf in which coral reefs are located.","South Sinai "));

        arrayList_place.add(new Data(R.drawable.mossa2, "Mount Moses", "abal Musa or Mount Tur Sinai is one of the most famous mountains in Sinai, as it rises 2,285 meters above sea level.\n" +
                "South Sinai, such as Mount Saint Catherine, which is known for its green color and is located close to it.\n" +
                "\n" +
                "The mountain is surrounded by a group of mountain peaks in\n" +
                "\n" +
                "2,037 meters.\n" +
                "Mount Moses, peace be upon him, is surrounded by mountains, which are colored in many colors. The mountain is considered one of the most wonderful landscapes. It is the best place for mountain safari and adventure lovers go to it.\n" +
                "\n" +
                "Ten Commandments according to the Jewish, Christian and\n" +
                "\n" +
                "Islam religions, as it is a holy place for Muslims, Christians and Jews, and there is also a Greek church Small and small lump.\n" +
                "\n" +
                "Antiquities of Lower Egypt and Sinai and in coordination with\n" +
                "\n" +
                "Saint Catherine City Council and the Ministry of Environment.","South Sinai "));

        arrayList_place.add(new Data(R.drawable.sant_katren, "Saint Catherine's Monastery  ", "Saint Catherine's Monastery is located in southern Sinai, Egypt, at the foot of Mount Catherine, the highest mountain in Egypt, near Mount Moses. It is said that it is the oldest monastery in the world. It is considered a major tourist attraction, as it is visited by tourist groups from all parts of the world. Although the guardianship of the monastery was for long periods of the Russian Orthodox Church.","South Sinai"));
        arrayList_place.add(new Data(R.drawable.white_desert, "The White Desert in Farafra", "The White Desert This strange phenomenon is among the deserts of the whole world, which is located in the Bahariya oasis in the north of the Farafra Oasis in the New Valley Governorate in Egypt, and its area is more than 3000 square kilometers. In the world as it is considered a marvel because of its unique phenomena and formations, so come with me to get to know them.","The new valley  "));



     //   arrayList_famous_place.add(new Data(R.drawable.abo_elhol, new String(String.valueOf(R.string.abo_elhole)).toString(), "desc1"));
        //arrayList_famous_place.add(new Data(R.drawable.abo_elhol, R.string.abo_elhole, "desc1"));

        arrayList_famous_place.add(new Data(R.drawable.abo_elhol, "sphinx", "desc1"));
        arrayList_famous_place.add(new Data(R.drawable.pyramids3, "Pyramids", "The pyramids of Egypt Giza in Cairo is located on the Giza plateau in the Giza governorate i.e. on the western bank of the Nile River. It includes three pyramids of Khufu, Khafre, and Menkaure which were built around 25 centuries BC and are royal tombs, each of which bears the name of the king who built it and who was buried in it and the building The hierarchy here is the stage of development of tomb architecture in ancient Egypt. The pyramids are one of the most important places of tourism in Egypt The three pyramids of Egypt are characterized as one of the most important seven wonders of the world, one of the largest gases, ancient and modern history, and the most important tourist places in Cairo.","Giza"));
        arrayList_famous_place.add(new Data(R.drawable.abo_simble4, "Abu Simbel", "As for the small temple of Abu Simbel, also known as the Temple of Hathor and Nefertari, it is the second temple in the history of ancient Egypt dedicated to a queen, as the first temple was dedicated to the great queen Nefertiti, which was allocated to her by her husband Akhenaten, and the small temple was built about 100 meters northeast of the temple The large temple was dedicated to the goddess Hathor, Rameses II and his wife Nefertari, and the façade decorated with rocks was decorated with two groups of giant statues separated by the large gate, and the statues that are slightly more than 10 meters high than the other statues are of the king and the queen, and it is striking here; That it is one of the few cases in Egyptian art, the statue of the king and the queen of equal size, and on both sides of the gate there are two statues of King Ramses II, wearing the white crown of Upper Egypt and the double crown, which are surrounded by statues of the queen, and there are also small statues of princes and princesses next to their parents .","Aswan"));
        arrayList_famous_place.add(new Data(R.drawable.kan_elkalily, "Khan Al-Khalily", "Khan Al-Khalili, an area in Al-Hussein neighborhood, Cairo, Egypt and is considered one of the most important markets in Old Cairo. It enjoys a great tourist attraction for visitors to Cairo and Egypt in general. It is characterized by the presence of popular bazaars, shops and restaurants, as well as the large number of tourists and the familiarity of its residents with them.\n" +
                " The khan bears the title of Khalili in reference to Sultan Jaharkas al-Khalili, one of the Sultans of the Circassian Mamelukes, who founded it in 1382 AD, that is, more than 620 years ago on the ruins of the tombs of the Fatimid caliphs in Egypt, which was known as “the saffron soil” and this soil had fees and returns that all the Fatimid caliphs were keen on. In terms of visiting and visiting it, lighting it and charity during the days of the Fatimid Caliphate.\n" +
                "\n","Cairo"));



        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product1","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product2","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product3","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product1","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product1","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product1","10"));
        arrayList_product.add(new DataProduct(R.drawable.backgrond,"product1","10","jfgjgjhgjhghg"));



        // object from DataAdapter send (context , array from data)
        adapter_place = new DataAdapter(Home.this, arrayList_place);
        adapter_famous_place = new DataAdapter(Home.this, arrayList_famous_place);
        adapter_product = new DataProductAddapter(Home.this, arrayList_product);



        //recyclerView.setHasFixedSize(true);

        recyclerView_all_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_all_place.setAdapter(adapter_place);

        recyclerView_top_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_place.setAdapter(adapter_famous_place);

        recyclerView_by_from_egypt.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_by_from_egypt.setAdapter(adapter_product);

    }

}