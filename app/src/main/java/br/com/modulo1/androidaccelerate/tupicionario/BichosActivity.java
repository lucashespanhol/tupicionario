package br.com.modulo1.androidaccelerate.tupicionario;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BichosActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_bichos);

        String[] bichosArray = getResources().getStringArray(R.array.bichos_array);
        // O ANDROID STUDIO COLOCA A ANOTIACAO FINAL PORQUE A VARIAVEL E USADA EM OUTRO CONTEXTO
        final String[] bichosDescArray = getResources().getStringArray(R.array.bichos_desc);

        ArrayList<Item> list = new ArrayList<Item>();

        for(int i = 0; i < 10; i++){
            String titulo = bichosArray[i];
            String descricao = bichosDescArray[i];

            Item item = new Item(titulo,descricao,R.drawable.ic_bichos);
            list.add(item);
        }
       /* PARTE UTILIZADA PARA EXEMPLIFICAR UM MODO NÃO PERFORMATICO DE TRABALHAR COM ARRAYS
       List<String> bichosList = Arrays.asList(bichosArray);
        //Recupera o layout
        LinearLayout root = (LinearLayout) findViewById(R.id.root_bichos);

        //for para percorrer a lista a atribuir os textViews no layout
        for(String bicho : bichosList){
            TextView textView = new TextView(this);
            textView.setText(bicho);
            root.addView(textView);
        }*/

        //CRIAÇÃO DE UM NOVO ARRAYADAPTER
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bichosArray);
        //CRIA COM O NOVO ADAPTER CRIADO
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.bichos_categoria);
        //RECUPERA A LISTVIEW
        ListView listView = (ListView) findViewById(R.id.root_bichos);
        //CRIA O ONITEMCLICKLISTENER
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = bichosDescArray[position];
                Toast.makeText(BichosActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
        //COLOCA O ADAPTER NA LISTVIEW
        listView.setAdapter(adapter);

    }
}
