package br.com.modulo1.androidaccelerate.tupicionario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CulinariaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinaria);

        String[] culinariaArray = getResources().getStringArray(R.array.culinaria_array);
        final String[] culinariaDescArray = getResources().getStringArray(R.array.culinarioa_desc);
        String titulo = "";
        String descricao = "";

        ArrayList<Item> list = new ArrayList<Item>();

        for(int i = 0; i < 10; i++){
            titulo = culinariaArray[i];
            descricao = culinariaDescArray[i];

            Item item = new Item(titulo,descricao,R.drawable.ic_culinaria);

            list.add(item);
        }
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.culinaria_categoria);
        ListView listView = (ListView) findViewById(R.id.root_culinaria);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = culinariaDescArray[position];
                Toast.makeText(CulinariaActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
