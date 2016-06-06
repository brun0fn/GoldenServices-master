package br.uva.goldenservices.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.uva.goldenservices.R;
import golden.services.model.anuncios.Anuncio;

/**
 * Created by Bruno on 05/06/2016.
 */
public class AnuncioAdapter extends ArrayAdapter<Anuncio> {

    private List<Anuncio> objects;

    public AnuncioAdapter(Context context, int textViewResourceId, List<Anuncio> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listar_servicos, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Anuncio anuncio = objects.get(position);

        if (anuncio != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            //TextView nomeServico = (TextView) v.findViewById(R.id.txtNomeServico);


            // check to see if each individual textview is null.
            // if not, assign some text!
            /*if (nomeServico != null){
                nomeServico.setText(anuncio.getDescricao());
            }*/

        }

        // the view must be returned to our activity
        return v;

    }

}
