package android.oscarbetanzos.com.miscontactos.fragment;

import android.os.Bundle;
import android.oscarbetanzos.com.miscontactos.R;
import android.oscarbetanzos.com.miscontactos.adapter.ContactoAdaptador;
import android.oscarbetanzos.com.miscontactos.pojo.Contacto;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;

    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.wine,"Oscar Betanzos","2224342910","oscar@gmail.com"));
        contactos.add(new Contacto(R.drawable.globe,"Omar Betanzos","2211603633","omar@gmail.com"));
        contactos.add(new Contacto(R.drawable.icecream,"Paty Sanchez","2225771514","paty@gmail.com"));
        contactos.add(new Contacto(R.drawable.orange,"Nani Gonzalez","2221243059","nani@gmail.com"));
    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }
}
