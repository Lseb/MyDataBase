package com.lsebastien.mydatabase;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
    private GererData datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creation de la BDD
        datasource = new GererData(this);
        datasource.open();

        int niveau=1;
        Data values = datasource.getAllDataByUser(niveau);


      //  ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this,
        //        android.R.layout.simple_list_item_1, values);
        //setListAdapter(adapter);

    }

    // Sera appelée par l'attribut onClick
    // des boutons déclarés dans main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Data> adapter = (ArrayAdapter<Data>) getListAdapter();
        Data data = null;
        switch (view.getId()) {
            case R.id.add:
                String[] Datas = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // enregistrer le nouveau Dataaire dans la base de données
                datasource.insertData(data);
                adapter.add(data);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    data = (Data) getListAdapter().getItem(0);
                    datasource.deleteData(data);
                    adapter.remove(data);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }


}
