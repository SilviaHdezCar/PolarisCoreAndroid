package com.example.wposs_user.polariscoreandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class CambiarClaveDialogo extends AppCompatDialogFragment {
    private TextView claveActual;
    private TextView clavenueva;
    private TextView claveConfirmarClave;
    private CambiarClaveListener listener;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.dialogcambiarclave, null);
        claveActual = view.findViewById(R.id.dialog_clave_actual);
        clavenueva = view.findViewById(R.id.dialog_clave_nueva);
        claveConfirmarClave = view.findViewById(R.id.dialog_clave_confirmar);

        builder.setView(view)

                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String actual=claveActual.getText().toString();
                        String nueva=clavenueva.getText().toString();
                        String confirmacion=claveConfirmarClave.getText().toString();

                        String msj=validarClave(actual, nueva,confirmacion);

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            return;
                    }
                });


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(CambiarClaveListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()+"Deber implementar CambiarClaveListener");
        }
    }

    public interface CambiarClaveListener{
        void applyTexts(String clave_actual, String clave_nueva, String clave_confirmar );
    }

    public String validarClave(String clave_actual, String clave_nueva, String clave_confirmar ){
        String msj="";



        return msj;
    }
}
