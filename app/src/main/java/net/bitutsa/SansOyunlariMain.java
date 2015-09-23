package net.bitutsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by dincer.keskin on 9/23/2015.
 */
public class SansOyunlariMain extends ActionBarActivity {


    private String[] sansoyunlari = {"Milli Piyango", "On Numara", "Şans Topu", "Süper Loto","Sayısal Loto"}; //Şans oyunları dizisi oluşturuldu
    int islem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sans_oyunlari_main);

        ListView listemiz=(ListView) findViewById(R.id.Lvsansoyunlari); //Listview nesnesi tanımlanıyor

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, sansoyunlari); //Listeye bağlanacak veri kaynağı oluşturuluyor.

        listemiz.setAdapter(veriAdaptoru); //veriler listeye bağlanıyor

        Bundle extras = getIntent().getExtras();
        islem = extras.getInt("islem");

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if(islem==1)
                {
                    Toast.makeText(getApplicationContext(), "Tahmin", Toast.LENGTH_SHORT).show();
                }else if(islem==0)
                {
                    Toast.makeText(getApplicationContext(), "Sonuç", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Sen bunu nasıl başardın ya :)", Toast.LENGTH_SHORT).show();
                }

                /*Intent intent = new Intent(SansOyunlariMain.this, ResultsMain.class);
                intent.putExtra("game_id",position);
                startActivity(intent);*/

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
