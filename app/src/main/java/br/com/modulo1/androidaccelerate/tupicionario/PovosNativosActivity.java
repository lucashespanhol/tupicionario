package br.com.modulo1.androidaccelerate.tupicionario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PovosNativosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_povos_nativos);

        String[] povosNativosArray = getResources().getStringArray(R.array.povos_nativos_array);
        final String[] povosNativosDescArray = getResources().getStringArray(R.array.povos_nativos_desc);
        String titulo = "";
        String descricao = "";
        Item item;

        ArrayList<Item> lista = new ArrayList<Item>();

        for(int i = 0; i < 10; i++){
            titulo = povosNativosArray[i];
            descricao = povosNativosDescArray[i];

            item = new Item(titulo,descricao,R.drawable.ic_povos_nativos);
            lista.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this,lista, R.color.povos_nativos_categoria);
        ListView listView = (ListView) findViewById(R.id.root_povos_nativos);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = povosNativosDescArray[position];
                Toast.makeText(PovosNativosActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
