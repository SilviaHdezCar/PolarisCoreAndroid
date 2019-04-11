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

    /*
    *
    * public String cambiarClave(String actual, String nueva, String confirmacion){
        //validar que no hayan cuadros vacio
        //validar que la clave sea mayor a 8caracteres
        //validar que la actual sea igual a la ingesada
        //que no ingrese simbolos--> se angrega android:digits.....
        //validar que la nueva y confirmacion sean iguales
        //revision de MayMimNum
        //clave nueva!= a la actual

        //colocar en el TextView:-->para que solo ingrese num y letras
        //<EditText android:inputType="text"
        //android:digits="0123456789abcdfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑ" />


    }



    */

    //este metodo hace las validaciones escritas en el cuaderno
    private String validarClave(String actual, String nueva, String confirmacion) {
        String msj="Actualización exitosa";
        //validaciones
        if (actual.isEmpty()) {
            return "Debe ingresar la contraseña actual";
        }else if(nueva.isEmpty()){
            return "Debe ingresar la contraseña nueva";
        }else if(confirmacion.isEmpty()){
            return "Debe confirmar la contraseña nueva";
        }else if(!actual.equals("1")){
            return "La contraseña actual es incorrecta";
        }else if(!(nueva.length()>=8)){
            return "La contraseña debe contener como minimo 8 caracteres";
        }else if(!revisarMayMinNum(nueva)){
            return "La contraseña debe contener números, letras en mayúscula y minúscula";
        }else if(nueva.equals(actual)){
            return "La contraseña  nueva debe ser diferente a la actual";
        }else if(!nueva.equals(confirmacion)){
            return "La confirmación de contraseña no coincide con la clave ingresada";
        }
        //consumir servicio para cambiar clave


        return msj;
    }

    //este metodo es para validar que la clave contenga numeros, letras minus y mayus
    public boolean revisarMayMinNum( String password){
        String msj="";

        char clave;

        byte  contNumero = 0;
        byte contLetraMay = 0;
        byte contLetraMin=0;

        for (byte i = 0; i < password.length(); i++) {

            clave = password.charAt(i);

            String passValue = String.valueOf(clave);

            if (passValue.matches("[A-Z]")) {

                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {

                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {

                contNumero++;
            }
        }
        if(contLetraMay>0 && contNumero>0 && contLetraMin>0){
            return true;
        }


        return false;
    }


}
