package com.volumidev.videogameslib;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Profile_Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_register_list;
    private List<Usuario> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

//  establece los setting iniciales
        initSettings();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Valida si se logo un Admin u otro user
     *
     * @return true si el user logado es Admin o false si el otro
     */
    private boolean isAdmin() {
        Intent i = getIntent();
        String user = i.getStringExtra("user");
        if (user.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Settea las vistas de los controles inicialmente
     */
    private void initSettings(){
        btn_register_list = findViewById(R.id.btn_register_list);
        btn_register_list.setOnClickListener(this);
        btn_register_list.setBackgroundColor(getResources().getColor(R.color.yellow_500));

        btn_register_list.setEnabled(isAdmin());
    }


    private void showUsersDialog(){
        Usuario u = new Usuario();
        //crear el dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.registered_user, null);
        builder.setView(dialogView);

        //rellenar el recicler view de dentro del dialog
        RecyclerView recycler = dialogView.findViewById(R.id.recycler_registered_users);
        recycler.setLayoutManager(new LinearLayoutManager( this ));

        list = u.getUsuariosFromDB(this);

        Register_Users_Adapter adapter = new Register_Users_Adapter(list, this);
        //adapter.setOnItemClickListener(new Register_Users_Adapter.OnItemClickListener());
        recycler.setAdapter(adapter);

        AlertDialog dialog = builder.create();
        dialog.show();
    }





    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register_list:
                Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
                    showUsersDialog();
                break;
        }
    }


}