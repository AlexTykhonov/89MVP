package com.tae.a89mvp.Edit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.tae.a89mvp.DB.ADb;
import com.tae.a89mvp.DB.Disc;
import com.tae.a89mvp.List.ListContract;
import com.tae.a89mvp.R;
import com.tae.a89mvp.Util.Constants;

import java.util.ArrayList;
import java.util.List;

public class AddDiscActivity extends AppCompatActivity implements EditDiscContract.View
{
    Disc disc;
    EditDiscContract.Presenter presenter;
    EditText discNameEditText;
    EditText authorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_thetask);

        discNameEditText = findViewById(R.id.ETdiscname);
        authorEditText = findViewById(R.id.ETautor);

        disc = new Disc();

        ADb db = ADb.getDatabase(this);
        presenter = new AddDiscPresenter(this,db.discDao());

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disc.setDisc(discNameEditText.getText().toString());
                disc.setAlbum(authorEditText.getText().toString());
                presenter.save(disc);
            }
        });

    }

    @Override
    public void showErrorMessage(int field) {
}

    @Override
    public void clearPreErrors() {

    }

    @Override
    public void close() { finish();

    }

    @Override
    public void populate(Disc disc) {

    }

    @Override
    public void setPresenter(EditDiscContract.Presenter presenter) {
        this.presenter=presenter;

    }
}