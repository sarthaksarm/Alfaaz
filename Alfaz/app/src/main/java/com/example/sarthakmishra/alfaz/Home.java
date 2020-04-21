package com.example.sarthakmishra.alfaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {
ListView lv;
ListAdapter listAdapter;
    EditText editText;
    ListView listView;
    ListViewAdapter adapter;
    String[] Name;
    String[] author;
    ArrayList<PeopleName> nameArrayList = new ArrayList<PeopleName>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Create string array
        Name = new String[]{"Afreen Afreen","Baapu Zimidar", "Badnam",
                "Gaal Ni Kadni", "Girls like you", "Paniyon Sa", "Piya Hazi Ali", "Qismat",
                "Tajdar-e-Haram", "Socha Hai", "Sultan","Wakhra Swag", "Yaarr Ni Milyaa", "Yaraan Piche"};

        author = new String[]{"Artist- Badshah", "Jassi Gill - Replay", "White Hill Music", "Speed Records",
                "Maroon 5 - Unknown artist", "Speed Records - Unknown album", "T-Series","Sufi Ashram- Unknown artist",
                 "Coke Studio Season-9",
                "Atif aslam, Coke Studio", "T-Series", "Speed Records", "Gurjazz - Laanedar", "Vishal_Dadlani -Sultan"};

        //Listview
        listView = (ListView)findViewById(R.id.list);

        //Set Data
        for (int i = 0; i < Name.length; i++){
            PeopleName PN = new PeopleName(Name[i],author[i]);
            nameArrayList.add(PN);
        }

        //The custom adapter
        adapter = new ListViewAdapter(this, nameArrayList);

        //Listview
        listView.setAdapter(adapter);

        //Edittext
        editText = (EditText)findViewById(R.id.Edt);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter
                String who = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(who);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}