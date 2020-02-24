package com.example.tugasmobile2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Detail extends AppCompatActivity {
    TextView nama,detail;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        foto = findViewById(R.id.i_foto);
        nama = findViewById(R.id.t_nama);
        detail = findViewById(R.id.t_detail);


        Bundle bundle = getIntent().getExtras();
        nama.setText(bundle.getString("nama"));
        detail.setText(bundle.getString("detail"));

        Glide.with(this)
                .load((bundle.getString("foto")))
                .apply(new RequestOptions().override(350, 550))
                .into(foto);




    }
}
