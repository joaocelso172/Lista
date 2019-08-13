package com.example.lista.lista;


import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lista.FiltrosFragment;
import com.example.lista.R;
import com.example.lista.VisualizacaoFragment;
import com.example.lista.adapter.adapterCar;
import com.example.lista.model.Carro;

import java.util.ArrayList;
import java.util.List;

import helper.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCarrosFragment extends Fragment {

    Dialog meuDialog;

    private RecyclerView rView;
    private adapterCar adaCar;
    private List<Carro> listaCarros = new ArrayList<>();
    private VisualizacaoFragment visu;
    private Button Filtros;
    ImageView imgView;
    public ListaCarrosFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        meuDialog = new Dialog(getContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Slide trans1 = new Slide();
            trans1.setDuration(3000);
            Fade trans2 = new Fade();
            trans2.setDuration(3000);
            ChangeBounds trans3 = new ChangeBounds();
            trans3.setDuration(3000);
            AutoTransition trans4 = new AutoTransition();
            trans4.setDuration(3000);

            this.setExitTransition(trans4);
            this.setReenterTransition(trans4);



        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_carros, container, false);
        imgView = view.findViewById(R.id.imageModelo);
        Filtros = view.findViewById(R.id.btnFiltros);
        rView = view.findViewById(R.id.recyclerCarros);
        rView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        rView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                               // meuDialog.setContentView(R.layout.fragment_visualizacao);

                                visu = new VisualizacaoFragment();
                                Carro carrinho = listaCarros.get(position);

                                visu.recebeDados(carrinho.getModeloCar());

                                FragmentTransaction telaCarro = getFragmentManager().beginTransaction();
                              //  teste.setCustomAnimations(android.R.anim.fade_in, 0);
                                telaCarro.replace(R.id.framePrincipal, visu);
                                telaCarro.commit();
                            //    meuDialog.show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    /*   Filtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irFiltros();
            }
        });*/

        return view;



    }

   // adaCar = new adapterCar(  );

    public void irFiltros() {
        FiltrosFragment filtros = new FiltrosFragment();
        FragmentTransaction filTransaction = getFragmentManager().beginTransaction();
        filTransaction.replace(R.id.FrameTest, filtros);

        ListaCarrosFragment lcarros = new ListaCarrosFragment();

        filTransaction.commit();
    }

    public void MostrarPopup(){

        meuDialog.setContentView(R.layout.fragment_visualizacao);
        TextView txtFechar;
      /*  txtFechar = (TextView) myDialog.findViewById(R.id.txtClose);

        txtFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });*/
        //  myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        meuDialog.show();

    }

    public void carregarCarros(){

        Carro carro1 = new Carro( "A3", R.drawable.a32018);
        listaCarros.add(carro1);

        Carro carro2 = new Carro("Gol", R.drawable.civic );
        listaCarros.add(carro2);

        Carro carro3 = new Carro("C3", R.drawable.a32018);
        listaCarros.add(carro3);

        Carro carro4 = new Carro("City", R.drawable.a32018);
        listaCarros.add(carro4);

        Carro carro5 = new Carro("Fit", R.drawable.a32018);
        listaCarros.add(carro5);


        /*Carro carro6 = new Carro();
        carro6.setNomeCarro("Civic");
        carro6.setModeloCar(R.drawable.a32018);
        listaCarros.add(carro6);*/

        adaCar = new adapterCar( listaCarros );


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rView.setLayoutManager(layoutManager);
        rView.setHasFixedSize(true);
        rView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        //adapter
        rView.setAdapter(adaCar);
    }

    @Override
    public void onStart() {
        carregarCarros();
        super.onStart();
    }
}
