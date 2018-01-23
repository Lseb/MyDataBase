package com.lsebastien.mydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public GererData datasource;

    Data values;
    int niveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creation de la BDD
        datasource = new GererData(this);
        datasource.open();

        niveau=3;
        values = datasource.getDataByUser(niveau);

        Button buttonYaw=(Button)findViewById(R.id.Yaw);
        buttonYaw.setOnClickListener((View.OnClickListener)this);

        Button buttonPitch=(Button)findViewById(R.id.Pitch);
        buttonPitch.setOnClickListener((View.OnClickListener)this);

        Button buttonRoll=(Button)findViewById(R.id.Roll);
        buttonRoll.setOnClickListener((View.OnClickListener)this);

        Button buttonUpDown=(Button)findViewById(R.id.UpDown);
        buttonUpDown.setOnClickListener((View.OnClickListener)this);
    }

    // Sera appelée par l'attribut onClick
    // des boutons déclarés dans main.xml
    public void onClick(View view) {
        //ArrayAdapter<Data> adapter = (ArrayAdapter<Data>) getListAdapter();
        System.out.println("ça passe");
        switch (view.getId()) {
            case R.id.Yaw:
                System.out.println("je suis vivant");
                System.out.println(values.getDeadzoneYaw());
                Double yaw=Double.parseDouble(values.getDeadzoneYaw());
                yaw=yaw+0.1;
                values.setDeadzoneYaw(yaw.toString());
                // enregistrer le nouveau Data dans la base de données
                datasource.updateData(niveau,values);
                ((TextView)findViewById(R.id.textYaw)).setText(yaw.toString());
                break;
            case R.id.Pitch:
                Double pitch=Double.parseDouble(values.getDeadzonePitch());
                pitch=pitch+0.1;
                values.setDeadzonePitch(pitch.toString());
                // enregistrer le nouveau Data dans la base de données
                datasource.updateData(niveau,values);
                ((TextView)findViewById(R.id.textPitch)).setText(pitch.toString());
                break;
            case R.id.Roll:
                Double roll=Double.parseDouble(values.getDeadzoneRoll());
                roll=roll+0.1;
                values.setDeadzoneRoll(roll.toString());
                // enregistrer le nouveau Data dans la base de données
                datasource.updateData(niveau,values);
                ((TextView)findViewById(R.id.textRoll)).setText(roll.toString());
                break;
            case R.id.UpDown:
                Double updown=Double.parseDouble(values.getDeadzoneUpDown());
                updown=updown+0.1;
                values.setDeadzoneUpDown(updown.toString());
                // enregistrer le nouveau Data dans la base de données
                datasource.updateData(niveau,values);
                ((TextView)findViewById(R.id.textUpDown)).setText(updown.toString());
                break;
        }
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
