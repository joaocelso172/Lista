package com.example.lista;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lista.lista.ListCarros;
import com.example.lista.lista.ListaCarrosFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {


    private CalendarView theDate;
    private TextView status;
    private TextView inicioViagem;
    private TextView fimViagem;
    private Button agendar;
    private Button altern;
    private ListaCarrosFragment telaCarros;
    private int lockTela;
    String data;
    String inicioAlugar;
    String fimAlugar;
    boolean inicio;
    boolean fim;

    public int getLockTela() {
        return lockTela;
    }

    public void setTst(int lockTela) {
        this.lockTela = lockTela;
    }

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View calendarioView = inflater.inflate(R.layout.fragment_data, container, false);

        theDate = (CalendarView) calendarioView.findViewById(R.id.Calendario);
        status = (TextView) calendarioView.findViewById(R.id.textstt);
        inicioViagem = (TextView) calendarioView.findViewById(R.id.textDataini);
        fimViagem = (TextView) calendarioView.findViewById(R.id.textDatafim);
        agendar = (Button) calendarioView.findViewById(R.id.btnAgendar);
        altern = (Button) calendarioView.findViewById(R.id.alterar);
        altern.setVisibility(View.GONE);

        theDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), "Item pressionado: " + dayOfMonth + month + year, Toast.LENGTH_SHORT);
                month++;
                data = dayOfMonth + "/" + month + "/" + year;
            }

        });

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicar();
            }
        });

        altern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alternClick();
            }
        });

        return calendarioView;



    }


    public void alternClick(){
        inicioAlugar = "";
        inicioViagem.setText("Retirada: " + inicioAlugar);
        inicio = false;
        fimAlugar = "";
        fimViagem.setText("Devolução: " + fimAlugar);
        fim = false;
        altern.setVisibility(View.GONE);
        agendar.setText("Agendar");
    }

    public void clicar (){
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.create();
        if (!inicio) {

            dialog.setMessage("Confirmar data de retirada de veículo? ");

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicioAlugar = data;
                    Toast.makeText(getContext(), "Retirada de veículo confirmada para " + inicioAlugar + ".", Toast.LENGTH_SHORT).show();
                    inicio = true;
                    inicioViagem.setText("Retirada: " + inicioAlugar);
                    status.setText("Escolha a data para devolução do veículo");
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicio = false;
                    Toast.makeText(getContext(), "Escolha a data para retirada de veículo", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
           /* inicioAlugar = data;
            inicio = true;*/


        } else if (!fim ) {
            dialog.setMessage("Confirmar data de devolução de veículo? ");

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fimAlugar = data;
                    Toast.makeText(getContext(), "Devolução de veículo confirmada para " + fimAlugar + ".", Toast.LENGTH_SHORT).show();
                    fim = true;
                    fimViagem.setText("Devolução: " + fimAlugar);
                    //  agendar.setText("Pagar");
                    status.setText("Confira a data e vá para o pagamento");
                    altern.setVisibility(View.VISIBLE);
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fim = false;
                    Toast.makeText(getContext(), "Escolha a data para retirada de veículo", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
        }else if (inicio && fim) {
            telaCarros = new ListaCarrosFragment();
          //  lockTela = 1;
          /*  FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frameConteudo, telaCarros);
            transaction.commit();*/
            Intent intent = new Intent(getContext(), ListCarros.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Retirada: " + inicioAlugar + ", Devolução: " + fimAlugar, Toast.LENGTH_SHORT).show();
           // Pagamento.setPagamentos(null);
        }

        /*inicioViagem.setText(inicioAlugar);
        fimViagem.setText(fimAlugar);*/

    }

}
