package br.com.modulo1.androidaccelerate.tupicionario;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item>{

    private int backgroundColor;

    public ItemAdapter(Context context, ArrayList<Item> list, int backgroundColor){
        super(context,0,list);
        this.backgroundColor = backgroundColor;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Coloca o contentView em uma variável propria para não trabalhar com ela
        View itemView = convertView;
        if(itemView == null){//Verifica se a view esta vazia, se estiver é preciso inflar a view com o nosso layout criado
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            //LayoutInflater é o metodo responsável por inflar o layout
            //.from(getContext()) é o contexto onde será criado o layout
            //.inflate recebe como parametros:
            //1 - layout criado, 2 - A ViewGroup responsável por criar a lista,
            // 3 - um boolean para não atrelar a view ao contexto
        }
        Item i = getItem(position);// o metodo getItem pertence ao arrayadapter

        TextView titulo = (TextView) itemView.findViewById(R.id.titulo_item);
        titulo.setText(i.getTitulo());

        TextView desc = (TextView) itemView.findViewById(R.id.descricao_item);
        desc.setText(i.getDescricao());

        ImageView icone = (ImageView) itemView.findViewById(R.id.image_item);
        icone.setImageResource(i.getImagem());

        LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R.id.textos_item);
        int cor = ContextCompat.getColor(getContext(), backgroundColor);
        // ContextCompat.getColor retorna uma cor e recebe como parametros o contexto e um int
        linearLayout.setBackgroundColor(cor);

        return itemView;
    }
}
