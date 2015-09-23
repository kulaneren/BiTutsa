package net.bitutsa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private String[] ulkeler =
            {"SONUÇLAR", "TAHMİN ÜRET"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(A) adımı
        ListView listemiz=(ListView) findViewById(R.id.lvMain);

        //(B) adımı
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (position==0){
                    Intent intent = new Intent(MainActivity.this, SansOyunlariMain.class);
                    intent.putExtra("islem",0);
                    startActivity(intent);

                }else if (position==1){
                    Intent intent = new Intent(MainActivity.this, SansOyunlariMain.class);
                    intent.putExtra("islem",1);
                    startActivity(intent);
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
