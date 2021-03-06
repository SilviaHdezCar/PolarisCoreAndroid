package com.example.wposs_user.polariscoreandroid;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.Vector;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
        setSupportActionBar(toolbar);
        agregarTeminalesVector();

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

        switch (item.getItemId()) {


            case R.id.btn_home:
                fragmentManager.beginTransaction().replace(R.id.contenedor_main, new InicialFragment()).commit();
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
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new ConsultaTerminalesReparadasFragm()).commit();

        } else if (id == R.id.nav_productividad) {
            fragmentManager.beginTransaction().replace(R.id.contenedor_main, new ProductividadFragment()).commit();

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
    public void actualizarClave(View view) {
        CambiarClaveDialogo cambiarClaveDialogo = new CambiarClaveDialogo();
        cambiarClaveDialogo.show(getSupportFragmentManager(), "Actualización de la clave.main");
    }



    //********************************************CONSULTAR TERMINALES*********************************************************************************************
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Vector<Terminal> terminales;

    private void agregarTeminalesVector(){
        this.terminales = new Vector<>();
        Terminal t1= new Terminal("12AAE4D", "Gertec", "Newpos9220", "WIFI", "nuevo", null);
        Terminal t2= new Terminal("GTDAE4D", "Gertec", "Newpos6210", "LAN", "Diagnostico", null);
        Terminal t3= new Terminal("ASFAFAD", "Gertec", "Newpos7210", "DIAL", "Reparación", null);
        terminales.add(t1);
        terminales.add(t2);
        terminales.add(t3);
    }

    //ESTE METODO LISTA LAS TERMINALES QUE TIENEN DIAGNOSTICO
    private Button btn_diagnostico;
    private Button btn_reparadas;

    public void verTerminalesDiasnostico(View view) {
        btn_diagnostico = (Button) findViewById(R.id.btn_terminales_diagnostico);
        btn_reparadas = (Button) findViewById(R.id.btn_terminales_reparadas);

        btn_diagnostico.setBackgroundColor(0x802196F5);

        btn_reparadas.setBackgroundColor(0x8045A5F3);


         Vector<Terminal> terminales_diagnostico = new Vector<>();
        for(Terminal ter:this.terminales){
            if (ter.getEstado().equalsIgnoreCase("Diagnostico")){
                terminales_diagnostico.add(ter);
            }

        }



        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_consultaTerminales);
        recyclerView.setAdapter(new AdapterTerminal(this, terminales_diagnostico));//le pasa los datos-> lista de usuarios

        layoutManager = new LinearLayoutManager(this);// en forma de lista
        recyclerView.setLayoutManager(layoutManager);


    }

    //ESTE METODO LISTA LAS TERMINALES REPARADAS
    public void verTerminalesReparadas(View view) {
        btn_diagnostico = (Button) findViewById(R.id.btn_terminales_diagnostico);
        btn_reparadas = (Button) findViewById(R.id.btn_terminales_reparadas);

        btn_reparadas.setBackgroundColor(0x802196F5);
        btn_diagnostico.setBackgroundColor(0x8045A5F3);

        Vector<Terminal> terminales_rep = new Vector<>();
        for(Terminal ter:this.terminales){
            if (ter.getEstado().equalsIgnoreCase("Reparación")){
                terminales_rep.add(ter);
            }

        }

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_consultaTerminales);
        recyclerView.setAdapter(new AdapterTerminal(this, terminales_rep));//le pasa los datos-> lista de usuarios

        layoutManager = new LinearLayoutManager(this);// en forma de lista
        recyclerView.setLayoutManager(layoutManager);;
    }
}



