package com.evertvd.greendaoinventario.vista.dialogs;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;


import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evertvd.greendaoinventario.R;
import com.evertvd.greendaoinventario.controlador.Controller;
import com.evertvd.greendaoinventario.modelo.Conteo;
import com.evertvd.greendaoinventario.modelo.Inventario;
import com.evertvd.greendaoinventario.modelo.Producto;
import com.evertvd.greendaoinventario.modelo.dao.ConteoDao;
import com.evertvd.greendaoinventario.modelo.dao.InventarioDao;
import com.evertvd.greendaoinventario.modelo.dao.ProductoDao;
import com.evertvd.greendaoinventario.utils.Operaciones;
import com.evertvd.greendaoinventario.vista.activitys.MainActivity;
import com.evertvd.greendaoinventario.vista.fragments.FrmResumen;

import java.util.List;


/**
 * Fragmento con un diálogo personalizado
 */
public class DialogCierreDiferencia extends DialogFragment implements View.OnClickListener {
    private static final String TAG = DialogCierreDiferencia.class.getSimpleName();
    private Button btnAceptar, btnCancelar;
    private EditText etCodigo;
    private TextView tvCodigoAleatorio;
    private TextInputLayout tilCodigo;
    private MenuItem menuResumen;
    View view;
    //MetodosAuxiliares metodosAuxiliares;

    public DialogCierreDiferencia() {
        //this.idProducto=idProducto;
        //metodosAuxiliares=new MetodosAuxiliares();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        // this.idProducto=idProducto;
        //recuperacion del parametro que viene del punto de invocacion del dialog--viene como string
        // idProducto = getArguments().getInt("idProducto");

        return crearAgregarCantidad();
    }

    /**
     * Crea un diÃ¡logo con personalizado para comportarse
     * como formulario de entrada de cantidad
     *
     * @return DiÃ¡logo
     */
    public AlertDialog crearAgregarCantidad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
            view = inflater.inflate(R.layout.dialogo_cerrar_inventario, null);
        //View v = inflater.inflate(R.layout.dialogo_registrar_conteo, null);

        tvCodigoAleatorio = (TextView) view.findViewById(R.id.tvCodAleatorio2);
        tvCodigoAleatorio.setText(String.valueOf(Operaciones.aleatorio()));

        etCodigo = (EditText) view.findViewById(R.id.etCodigo);

        btnCancelar = (Button) view.findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);

        btnAceptar = (Button) view.findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);

        tilCodigo = (TextInputLayout) view.findViewById(R.id.tilCodigo);

        builder.setView(view);
        builder.setTitle("Cerrar Diferencias");
        builder.setMessage("Ingresar el código generado para confirmar el cierre de las diferencias");
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAceptar) {
            if (validarCodigo(tilCodigo.getEditText().getText().toString())) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute(String.valueOf(1));
                this.dismiss();

            }
        } else if (v.getId() == R.id.btnCancelar) {
            this.dismiss();
        }
    }

    private boolean validarCodigo(String etCodigo) {
        if (etCodigo.trim().length() == 0 || etCodigo.equals(tvCodigoAleatorio.getText()) != true) {
            tilCodigo.setError("Los códigos no coinciden");
            return false;

        } else {
            tilCodigo.setError(null);
        }

        return true;
    }

    private void habilitarMenus() {
        NavigationView navView = (NavigationView)getActivity().findViewById(R.id.nav_view);
        Menu menuNav = navView.getMenu();

        MenuItem menuDiferencia = menuNav.findItem(R.id.nav_diferencias);
        menuDiferencia.setEnabled(false);


        MenuItem menuInventario = menuNav.findItem(R.id.nav_inventario);
        menuInventario.setEnabled(false);

        menuResumen= menuNav.findItem(R.id.nav_resumen);
        menuResumen.setEnabled(true);
        menuResumen.setChecked(true);

        MenuItem menuNuevoProducto= menuNav.findItem(R.id.nav_nuevo_Producto);
        menuNuevoProducto.setEnabled(false);



    }

    private void abrirFragmentResumen() {
        //tabLayout.setVisibility(View.VISIBLE);
        Inventario inventario=Controller.getDaoSession().getInventarioDao().queryBuilder().where(InventarioDao.Properties.Estado.eq(0)).unique();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FrmResumen frmResumen=new FrmResumen();
        fragmentTransaction.replace(R.id.contenedor, frmResumen);
        getActivity().setTitle(menuResumen.getTitle()+" Inv. "+inventario.getNuminventario());
        fragmentTransaction.commit();


        //startActivity(new Intent(getActivity(), MainActivity.class));
        //getActivity().finish();
    }

    private void asignarContextoResumen() {
        Inventario inventario = Controller.getDaoSession().getInventarioDao().queryBuilder().where(InventarioDao.Properties.Estado.eq(0)).unique();
        inventario.setContexto(3);//diferencia
        inventario.setFechaCierre(Operaciones.fechaActual());
        Controller.getDaoSession().getInventarioDao().update(inventario);

    }

    private List<Conteo> listarConteos(long idProducto){
        List<Conteo> conteoList=Controller.getDaoSession().getConteoDao().queryBuilder().where(ConteoDao.Properties.Producto_id.eq(idProducto))
                .where(ConteoDao.Properties.Estado.notEq(-1)).list();//evitar los registros eliminados;
        return conteoList;
    }

    private void calcularDiferencias(){
        //listar productos de inventario actual
        //listar conteos de productos listados
        Inventario inventario=Controller.getDaoSession().getInventarioDao().queryBuilder().where(InventarioDao.Properties.Estado.eq(0)).unique();

        List<Producto> productoList=Controller.getDaoSession().getProductoDao().queryBuilder().where(ProductoDao.Properties.Inventario_id.eq(inventario.getId())).list();


        for (int i=0; i<productoList.size();i++){

            List<Conteo>conteoList=listarConteos(productoList.get(i).getId());


            int totalConteo=0;
            //List<Conteo>conteoList=Controller.getDaoSession().getConteoDao().queryBuilder().where(ConteoDao.Properties.Producto_id.eq(productoList.get(i).getId())).list();
                for (int j=0; j<conteoList.size();j++){
                    totalConteo+=conteoList.get(j).getCantidad();
                    //Log.e("totalConteo: ",String.valueOf(totalConteo));
                }
            if(totalConteo-productoList.get(i).getStock()!=0){
                productoList.get(i).setEstado(-1);
                productoList.get(i).update();
            }else{
                productoList.get(i).setEstado(0);
                productoList.get(i).update();
            }

            Log.e("esstadoProd: ",String.valueOf(productoList.get(i).getEstado()));
        }



    }


    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;
                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            //abrirFragmentDiferencia();
            progressDialog.dismiss();
            //abrirFragmentDiferencia(menuDiferencia);
            //startActivity(new Intent(getActivity(), MainActivity.class));
            //finalResult.setText(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(),"","Generando resumen...");

        }


        @Override
        protected void onProgressUpdate(String... text) {
            habilitarMenus();
            asignarContextoResumen();
            calcularDiferencias();
            abrirFragmentResumen();

        }
    }



}
