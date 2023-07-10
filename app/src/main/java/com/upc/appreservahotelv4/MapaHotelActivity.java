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
import java.util.HashMap;
import java.util.List;

public class MapaHotelActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    private TextView txtNombHotel;
    private TextView tvPrecHotel;
    private HashMap<Marker, LocationInfo> markerLocationMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_hotel);

        txtNombHotel = (TextView) findViewById(R.id.txtNombHotel);
        tvPrecHotel = (TextView) findViewById(R.id.tvPrecHotel);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapabusqueda);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(this);

        markerLocationMap = new HashMap<>();
    }

    @Override

   public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        ArrayList<LocationInfo> ubicaciones = new ArrayList<>();
        ubicaciones.add(new LocationInfo(-13.51504486681824, -71.96907086736691, "Hotel 1", "150.00", 1, "2023-07-01", "2023-07-05"));
        ubicaciones.add(new LocationInfo(-13.520346, -71.964522, "Hotel 2", "100.00", 2, "2023-07-02", "2023-07-06"));
        ubicaciones.add(new LocationInfo(-13.522123, -71.967821, "Hotel 3", "89.00", 3, "2023-07-03", "2023-07-07"));

        for (LocationInfo ubicacion : ubicaciones) {
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(ubicacion.getLatitud(), ubicacion.getLongitud()))
                    .title(ubicacion.getTitulo())
                    .icon(cambiarIcono(this, R.drawable.ico_hotel)));

            // Asocia el marcador con la ubicación correspondiente
            markerLocationMap.put(marker, ubicacion);
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                LocationInfo locationInfo = markerLocationMap.get(marker);
                if (locationInfo != null) {
                    txtNombHotel.setText(locationInfo.getTitulo());
                    tvPrecHotel.setText("S/. "+ String.valueOf(locationInfo.getPrecio()));
                }
                return false;
            }
        });

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