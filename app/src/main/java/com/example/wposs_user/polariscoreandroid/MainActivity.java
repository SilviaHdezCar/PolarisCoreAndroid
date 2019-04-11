package com.example.wposs_user.polariscoreandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CambiarClaveDialogo.CambiarClaveListener {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    Tab_terminal tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor_main, new InicialFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor_main, new InicialFragment()).commit();
        switch (item.getItemId()) {


            case R.id.btn_home:
                i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
                return true;

            case R.id.btn_aumentar:
                aumentar();
                return true;

            case R.id.btn_disminuir:
                dismuir();
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    private void dismuir() {

    }

    private void aumentar() {
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // AL SELECCIONAR ALGUUNA OPCION DEL MENU
        FragmentManager fragmentManager = getSupportFragmentManager();
        int id = item.getItemId();
        if (id == R.id.nav_perfil) {
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new PerfilFragment()).commit();
            // cargarDatosPerfil();
        } else if (id == R.id.nav_stock) {
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new StockFragment()).commit();
        } else if (id == R.id.nav_consultar_terminales_reparadas) {
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new ConsultaTerminalesReparadasFragment()).commit();
        } else if (id == R.id.nav_productividad) {
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new ProductividadFragment()).commit();
            ;
        } else if (id == R.id.nav_cerrar_sesion) {
            Intent i = new Intent(this, Activity_login.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private ImageView imgPerfil;
    private TextView nomUsuario;
    private TextView usuario;
    private TextView cargo;
    private TextView telefono;
    private TextView correo;
    private TextView ubicacion;


    void cargarDatosPerfil() {
        imgPerfil = findViewById(R.id.perfil_imagen_usuario);
        //imgPerfil.setBackground();//agregar img que viene del servicio (json) al campo  imagenText

        nomUsuario = (TextView) findViewById(R.id.perfil_nombre_usuario);
        nomUsuario.setText("Silvia HC");//agregar el nomUser que viene del servicio (json) al campo  nombre usuario

        usuario = (TextView) findViewById(R.id.perfil_usuario);
        usuario.setText("");//agregar el nomUser que viene del servicio (json) al campo  usuario

        cargo = (TextView) findViewById(R.id.perfil_cargo);
        cargo.setText("Tecnica");//agregar el cargo que viene del servicio (json) al campo  respectivo

        telefono = (TextView) findViewById(R.id.perfil_telefono);
        telefono.setText("3113203021");//agregar el telefono que viene del servicio (json) al campo  respectivo

        correo = (TextView) findViewById(R.id.perfil_correo);
        correo.setText("silviahernadez@wposs.com");//agregar el cargo que viene del servicio (json) al campo  respectivo

        ubicacion = (TextView) findViewById(R.id.perfil_ubicacion);
        ubicacion.setText("Colombia. Cúcuta");//agregar el telefono que viene del servicio (json) al campo  respectivo


    }


    //METODO QUE MUESTRA EL PANEL PARA ACTUALIZAR LA CLAVE
    private TextView claveActual;
    private TextView clavenueva;
    private TextView claveConfirmarClave;
    private Button btn_cambiarClave;

    //dialog_clave_actual-->edit_username___dialog

    public void actualizarClave(View view) {
        //claveActual = (TextView) findViewById(R.id.dialog_clave_actual);
        //clavenueva = (TextView) findViewById(R.id.dialog_clave_nueva);
        //claveConfirmarClave = (TextView) findViewById(R.id.dialog_clave_confirmar);

        claveActual = (TextView) findViewById(R.id.actual);//textview_username voy a mostar los campos iongresados
        clavenueva = (TextView) findViewById(R.id.nueva);
        claveConfirmarClave = (TextView) findViewById(R.id.confirmar);

        abrirCambiarClave();
    }

    private void abrirCambiarClave() {
        CambiarClaveDialogo cambiarClaveDialogo = new CambiarClaveDialogo();
        cambiarClaveDialogo.show(getSupportFragmentManager(), "Actualización de la clave.main");
    }


    @Override
    public void applyTexts(String clave_actual, String clave_nueva, String clave_confirmar) {
        claveActual.setText(clave_actual);
        clavenueva.setText(clave_nueva);
        claveConfirmarClave.setText(clave_confirmar);
    }
}



