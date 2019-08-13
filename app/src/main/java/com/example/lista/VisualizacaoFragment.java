package com.example.lista;


import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lista.lista.ListaCarrosFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisualizacaoFragment extends Fragment {

    String nome;
    int foto;
    Dialog mDialog;

    public VisualizacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDialog = new Dialog(getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide trans1 = new Slide();
            trans1.setDuration(3000);
            Fade trans2 = new Fade();
            trans2.setDuration(3000);
            ChangeBounds trans3 = new ChangeBounds();
            trans3.setDuration(3000);
            AutoTransition trans4 = new AutoTransition();
            trans4.setDuration(3000);

            this.setEnterTransition(trans4);
            this.setReturnTransition(trans4);


        }


        // Inflate the layout for this fragment
        View vFrag = inflater.inflate(R.layout.fragment_visualizacao, container, false);

        ListaCarrosFragment listaCarros = new ListaCarrosFragment();


        ImageView fotoCar = (ImageView) vFrag.findViewById(R.id.imgCarro);
        fotoCar.setImageResource(foto);
     //   Log.i("Carro", String.valueOf(foto));
       /* TextView modeloCarro = (TextView) findViewById(R.id.modeloCar);
        TextView fabricante = (TextView) findViewById(R.id.montadoraCar);
        TextView anoFabrica = (TextView) findViewById(R.id.anoCar);
        TextView precoAlug = (TextView) findViewById(R.id.valorCar);
        foto.setImageResource(informCarro.fotoCarro);
        modeloCarro.setText(informCarro.nomeCarro);
        fabricante.setText(informCarro.montadora);
        anoFabrica.setText(informCarro.anoFab);
        precoAlug.setText(informCarro.valor);*/

        return vFrag;
    }

    public void recebeDados(int fotoCarro){
        // nome = nomeCarro;
        foto = fotoCarro;
        //  myDialog.setContentView(R.layout.fragment_visualizacao);
        //mDialog.show();
    }

}
