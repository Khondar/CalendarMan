package com.example.basil.calendarman;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by basil on 22/06/2016.
 */
public class FragmentCalendar extends Fragment
{

    EditText nome;
    EditText giornoI;
    EditText meseI;
    EditText annoI;
    EditText oraI;
    EditText minutiI;
    EditText giornoF;
    EditText meseF;
    EditText annoF;
    EditText oraF;
    EditText minutiF;
    Button carica;
    Button visualizza;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.menu_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nome = (EditText) view.findViewById(R.id.nome_evento);
        giornoI = (EditText) view.findViewById(R.id.giorno_evento);
        meseI = (EditText) view.findViewById(R.id.mese_evento);
        annoI = (EditText) view.findViewById(R.id.anno_evento);
        oraI = (EditText) view.findViewById(R.id.ora_evento);
        minutiI = (EditText) view.findViewById(R.id.minuto_evento);
        giornoF = (EditText) view.findViewById(R.id.giorno_fine_evento);
        meseF = (EditText) view.findViewById(R.id.mese_fine_evento);
        annoF = (EditText) view.findViewById(R.id.anno_fine_evento);
        oraF = (EditText) view.findViewById(R.id.ora_fine_evento);
        minutiF = (EditText) view.findViewById(R.id.minuto_fine_evento);

        carica = (Button) view.findViewById(R.id.invia);
        visualizza = (Button) view.findViewById(R.id.ricevi);

        carica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               MyEvent evento = new MyEvent();
                evento.setNome(nome.getEditableText().toString());
                evento.setGiornoI(Integer.parseInt(giornoI.getEditableText().toString()));
                evento.setGiornoF(Integer.parseInt(giornoF.getEditableText().toString()));
                evento.setMeseI(Integer.parseInt(meseI.getEditableText().toString()));
                evento.setMeseF(Integer.parseInt(meseF.getEditableText().toString()));
                evento.setAnnoI(Integer.parseInt(annoI.getEditableText().toString()));
                evento.setAnnoF(Integer.parseInt(annoF.getEditableText().toString()));
                evento.setOraI(Integer.parseInt(oraI.getEditableText().toString()));
                evento.setOraF(Integer.parseInt(oraF.getEditableText().toString()));
                evento.setMinutiI(Integer.parseInt(minutiI.getEditableText().toString()));
                evento.setMinutiF(Integer.parseInt(minutiF.getEditableText().toString()));
            }
        });
    }
}
