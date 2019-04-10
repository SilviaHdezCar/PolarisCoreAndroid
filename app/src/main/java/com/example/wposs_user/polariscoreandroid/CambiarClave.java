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

public class CambiarClave extends AppCompatDialogFragment {
    private TextView claveActual;
    private TextView clavenueva;
    private TextView claveConfirmarClave;
    private CambiarClaveListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.dialogcambiarclave, null);

        builder.setView(view)
                .setTitle("Cambiar clave")
                // Add action buttons
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String actual=claveActual.getText().toString();
                        String nueva=clavenueva.getText().toString();
                        String confirmar=claveConfirmarClave.getText().toString();
                        listener.applyTexts(actual, nueva, confirmar);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        claveActual = view.findViewById(R.id.dialog_clave_actual);
        clavenueva = view.findViewById(R.id.dialog_clave_nueva);
        claveConfirmarClave = view.findViewById(R.id.dialog_clave_confirmar);

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
}
