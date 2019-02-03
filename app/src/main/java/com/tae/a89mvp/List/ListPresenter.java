package com.tae.a89mvp.List;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.tae.a89mvp.DB.Disc;
import com.tae.a89mvp.DB.DiscDao;

import java.util.List;

public class ListPresenter implements ListContract.Presenter {

    private ListContract.View view;
    private DiscDao discDao;

    public ListPresenter(ListContract.View view, DiscDao discDao) {
        this.view = view;
        this.view.setPresenter(this);
        this.discDao = discDao;
    }

    @Override
    public void start() {

    }

    @Override
    public void addDisc() {
    view.showAddDisc();
    }

    // empty
    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void populateDisc() {
        discDao.findAllDiscs().observeForever(new Observer<List<Disc>>() {
            @Override
            public void onChanged(@Nullable List<Disc> discs) {
                view.setDiscs(discs);
                if (discs == null || discs.size() < 1) {
                    view.showEmptyMessage();
                }
            }
        });
    }

    @Override
    public void openAddDiscActivity(Disc disc) {
     view.showEditScreen(disc.id);
    }

    @Override
    public void openConfirmDeleteDialog(Disc disc) {
        view.showDeleteConfirmDialog(disc);
    }

    @Override
    public void delete(long discId) {

            Disc disc = discDao.findDisc(discId);
            discDao.delete(disc);
    }


}
