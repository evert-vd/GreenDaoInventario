package com.evertvd.greendaoinventario.vista.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.evertvd.greendaoinventario.R;
import com.evertvd.greendaoinventario.controlador.Controller;
import com.evertvd.greendaoinventario.modelo.Inventario;
import com.evertvd.greendaoinventario.modelo.Producto;
import com.evertvd.greendaoinventario.modelo.Zona_has_Inventario;
import com.evertvd.greendaoinventario.modelo.dao.InventarioDao;
import com.evertvd.greendaoinventario.modelo.dao.ProductoDao;
import com.evertvd.greendaoinventario.modelo.dao.Zona_has_InventarioDao;
import com.evertvd.greendaoinventario.utils.Operaciones;
import com.evertvd.greendaoinventario.vista.adapters.ZonaResAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrmResumenZona extends Fragment {
    private static View view;
    private static Context context;
    private TextView txttotal, txtResumenZona;

    public FrmResumenZona() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_resumen_zona, container, false);
        context = getActivity();

        String tituloResumenZona = "resumen por zona";
        txttotal = (TextView) view.findViewById(R.id.txtTotal);
        txtResumenZona = (TextView) view.findViewById(R.id.txtResumenZona);
        txtResumenZona.setText(tituloResumenZona.toUpperCase());





        // A. Creamos el arreglo de Strings para llenar la lista
        Inventario inventario = Controller.getDaoSession().getInventarioDao().queryBuilder().where(InventarioDao.Properties.Estado.eq(0)).unique();
        List<Zona_has_Inventario> zona_has_inventarioList = Controller.getDaoSession().getZona_has_InventarioDao().queryBuilder().
                where(Zona_has_InventarioDao.Properties.Inventario_id2.eq(inventario.getId())).list();
        //IConteo iConteo=new Sqlite_Conteo();
        int totalConteo = 0;

        List<Producto> productoListZona = Controller.getDaoSession().getProductoDao().queryBuilder().where(ProductoDao.Properties.Inventario_id.eq(inventario.getId())).list();


        for (int i = 0; i < productoListZona.size(); i++) {
            totalConteo += Operaciones.totalConteoProducto1(productoListZona.get(i).getId());
        }


        txttotal.setText(String.valueOf(totalConteo));

        // B. Creamos un nuevo ArrayAdapter con nuestra lista
        ZonaResAdapter adapter = new ZonaResAdapter(getActivity(), zona_has_inventarioList);

        // C. Seleccionamos la lista de nuestro layout
        ListView miLista = (ListView)view.findViewById(R.id.listaResumenZona);
        miLista.setAdapter(adapter);


        return view;
    }
}