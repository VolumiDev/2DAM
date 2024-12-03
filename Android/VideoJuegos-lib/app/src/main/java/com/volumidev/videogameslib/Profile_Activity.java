package com.volumidev.videogameslib;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diego
 */
public class Profile_Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_register_list, btn_newGame;
    private List<Usuario> list;
    private RecyclerView rv_favGames;
    private GameRecyclerAdapter gamesAdapter;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        //RECOGEMOS EL INTENT
        Intent i = getIntent();
        user = (Usuario) i.getSerializableExtra("user");

        // ESTABLECE LAS VISTAS
        initSettings();

        //CONFIGURAMOS EL ADAPTER
        rv_favGames.setLayoutManager(new LinearLayoutManager(this));
        gamesAdapter = new GameRecyclerAdapter(new ArrayList<Game>(), this);
        gamesAdapter.setGameList(getFavGames());
        rv_favGames.setAdapter(gamesAdapter);

        //CONFIGURAMOS EL SWIPE CONTROLLER
        ProfileSwipeController profileSwipeController = new ProfileSwipeController(gamesAdapter, user, this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(profileSwipeController);
        itemTouchHelper.attachToRecyclerView(rv_favGames);


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
        rv_favGames = findViewById(R.id.recyclerView_favGames);
        btn_newGame = findViewById(R.id.shearch_newGame);
        btn_newGame.setOnClickListener(this);
        btn_newGame.setBackgroundColor(getResources().getColor(R.color.yellow_500));

        btn_register_list = findViewById(R.id.btn_register_list);
        btn_register_list.setOnClickListener(this);
        btn_register_list.setBackgroundColor(getResources().getColor(R.color.yellow_500));
        if(isAdmin()){
            btn_register_list.setVisibility(View.GONE);
        } else{
            btn_register_list.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Muestra la lista de usuarios registrados
     */
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

    /**
     * Recogemos los juegos favoritos del usuario
     * @return
     */
    private List<Game> getFavGames(){
        List<Game> list_favGames = new ArrayList<>();
        Conexion con = Conexion.getInstance();
        SQLiteDatabase db = con.getReadableDatabase();
        String sql = "SELECT * from videojuegos WHERE id_usuario = " + user.getId();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.isBeforeFirst()){
            while(cursor.moveToNext()){
                Game g = new Game();
                //g.setFavorite_id(cursor.getInt(0));
                g.setName(cursor.getString(1)); //recogemos el nombre
                Image img = new Image();
                img.setSmallUrl(cursor.getString(5)); //recogemos la imagen
                g.setImage(img);

                list_favGames.add(g);
            }
        }else{
            Game error = new Game();

            error.setName("No hay juegos favoritos");
            list_favGames.add(error);
        }
        return list_favGames;
    }




    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register_list:
                Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show();
                    showUsersDialog();
                break;
            case R.id.shearch_newGame:
                Intent i = new Intent(this, GameSearchActivity.class);
                i.putExtra("user", user);
                startActivity(i);
                break;
        }
    }


}