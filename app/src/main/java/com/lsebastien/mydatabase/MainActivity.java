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
        List<Data> values = datasource.getAllDataByLevel(niveau);
        ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

    }

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Data> adapter = (ArrayAdapter<Data>) getListAdapter();
        Data data = null;
        switch (view.getId()) {
            case R.id.augmenter:
                String[] variable = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // enregistrer le nouveau commentaire dans la base de données
                data = datasource.createData(variable[nextInt]);
                adapter.add(data);
                break;
            case R.id.diminer:
                if (getListAdapter().getCount() > 0) {
                    data = (Data) getListAdapter().getItem(0);
                    datasource.deleteData(data);
                    adapter.remove(data);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
