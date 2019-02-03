package com.tae.a89mvp.List;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.tae.a89mvp.DB.ADb;
import com.tae.a89mvp.DB.Disc;
import com.tae.a89mvp.Edit.AddDiscActivity;
import com.tae.a89mvp.R;
import com.tae.a89mvp.Util.Constants;
import com.tae.a89mvp.Util.DiscAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListContract.View, ListContract.OnItemClickListener, ListContract.DeleteListener {
    private ListContract.Presenter mPresenter;
    private FloatingActionButton buttonAddTask;
    private RecyclerView recyclerView;
    DiscAdapter discAdapter;
    private TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmptyTextView = findViewById(R.id.emptytext);

        recyclerView = findViewById(R.id.recyclerview_tasks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        discAdapter = new DiscAdapter(this);
        recyclerView.setAdapter(discAdapter);

        buttonAddTask = findViewById(R.id.floatingActionButton);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showAddDisc();
            }
        });

        ADb db = ADb.getDatabase(getApplication());
        mPresenter = new ListPresenter(this, db.discDao());
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.populateDisc();
    }

    @Override
    public void showAddDisc() {
        Intent intent = new Intent(MainActivity.this, AddDiscActivity.class);
        startActivity(intent);
    }

    @Override
    public void setDiscs(List<Disc> discs) {
            mEmptyTextView.setVisibility(View.GONE);
            discAdapter.setValues(discs);
        System.out.println("THIS IS DISCS ?????????                ----   "+discs);
    }

    @Override
    public void showEditScreen(long id) {
        Intent intent = new Intent(this, AddDiscActivity.class);
        intent.putExtra(Constants.DISC_ID, id);
        startActivity(intent);
    }

    @Override
    public void showDeleteConfirmDialog(Disc disc) {
        DeleteConfirmFragment fragment = new DeleteConfirmFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(Constants.DISC_ID, disc.id);
        fragment.setArguments(bundle);
        fragment.show(getSupportFragmentManager(), "confirmDialog");
    }

    @Override
    public void showEmptyMessage() {
        mEmptyTextView.setVisibility(View.VISIBLE);

    }

    @Override
    public void setPresenter(ListContract.Presenter presenter) {
    this.mPresenter = presenter;
    }

    @Override
    public void clickItem(Disc disc) {
        mPresenter.openAddDiscActivity(disc);
    }

    @Override
    public void clickLongItem(Disc disc) {
        mPresenter.openConfirmDeleteDialog(disc);
    }

    @Override
    public void setConfirm(boolean confirm, long id) {
       if (confirm) {
           mPresenter.delete(id);

       }
    }
}