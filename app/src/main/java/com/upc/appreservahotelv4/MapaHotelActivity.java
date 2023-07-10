package com.upc.appreservahotelv4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapaHotelActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    float latitud,longitud;
    String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_hotel);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapabusqueda);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(this);
    }

    @Override

    /*
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // LatLng upc = new LatLng(latitud, longitud);
        LatLng upc = new LatLng(-13.51504486681824, -71.96907086736691);
        mMap.addMarker(new MarkerOptions()
                .position(upc)
                .title("prueba")
                .icon(cambiarIcono(this,R.drawable.ico_hotel))
        );
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(upc,17));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(@NonNull LatLng latLng) {
                // Log.d("==>",latLng.toString());

                try {
                    List<Address> listaDirecciones = geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
                    if (listaDirecciones.size() > 0){
                        Address direccion = listaDirecciones.get(0);
                        String nombreDireccion = direccion.getAddressLine(0);
                        mMap.addMarker(new MarkerOptions().position(latLng).title(nombreDireccion));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }
    */

    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        ArrayList<LocationInfo> ubicaciones = new ArrayList<>();
        ubicaciones.add(new LocationInfo(-13.51504486681824, -71.96907086736691, "Ubicación 1", "Nombre 1"));
        ubicaciones.add(new LocationInfo(-13.520346, -71.964522, "Ubicación 2", "Nombre 2"));
        ubicaciones.add(new LocationInfo(-13.522123, -71.967821, "Ubicación 3", "Nombre 3"));

        for (LocationInfo ubicacion : ubicaciones) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(ubicacion.getLatitud(), ubicacion.getLongitud()))
                    .title(ubicacion.getTitulo())
                    .icon(cambiarIcono(this, R.drawable.ico_hotel)));
        }

        // Listener para detectar el evento de finalización del diseño
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (LocationInfo ubicacion : ubicaciones) {
                    builder.include(new LatLng(ubicacion.getLatitud(), ubicacion.getLongitud()));
                }
                LatLngBounds bounds = builder.build();
                int padding = 50; // Espacio adicional en píxeles alrededor de los marcadores
                mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(@NonNull LatLng latLng) {
                try {
                    List<Address> listaDirecciones = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (!listaDirecciones.isEmpty()) {
                        Address direccion = listaDirecciones.get(0);
                        String nombreDireccion = direccion.getAddressLine(0);
                        mMap.addMarker(new MarkerOptions().position(latLng).title(nombreDireccion));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private BitmapDescriptor cambiarIcono(Context context, int id){
        Drawable imagen = ContextCompat.getDrawable(context,id);
        imagen.setBounds(0,0,imagen.getIntrinsicWidth(),imagen.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(imagen.getIntrinsicWidth(), imagen.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imagen.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);

    }
}