package com.example.jorge.guatapeturistico;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TurismoActivity extends AppCompatActivity {


//    String[] sitios = new String[] {"La Piedra del Peñol","Plazoleta de Zócalos","Represa"};


    Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.rest1,17910,26866, "Pizzería De Luigi" ," Italiana, Pizza, Apto para vegetarianos, Opciones veganas "),
            new Lista_Entrada(R.drawable.rest2,0, 0, "Café La Viña","Café, Colombiana "),
            new Lista_Entrada(R.drawable.rest3,8955, 28851,"Thai Terrace"," Tailandesa, Asiática, Apto para vegetarianos, Opciones veganas ")
    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);

  //      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sitios);

        Adapter adapter = new Adapter(this,datos);

        lista = (ListView) findViewById(R.id.Lista);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                String opcion = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(),opcion,Toast.LENGTH_SHORT).show();

            }
        });

    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{


        public Adapter( Context context, Lista_Entrada[] datos) {
            super(context,R.layout.listview_item,datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.tInter);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDes1);
            descrip.setText(datos[position].getDescripcion());

            TextView precio1 = (TextView) item.findViewById(R.id.tPrec1);
            precio1.setText(String.valueOf(datos[position].getPrecio1()));

            TextView precio2 = (TextView) item.findViewById(R.id.tPrec2);
            precio2.setText(String.valueOf(datos[position].getPrecio2()));

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());


            return item;
        }
    }

}
