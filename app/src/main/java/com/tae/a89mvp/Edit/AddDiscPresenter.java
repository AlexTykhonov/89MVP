package com.tae.a89mvp.Edit;

import com.tae.a89mvp.DB.Disc;
import com.tae.a89mvp.DB.DiscDao;

public class AddDiscPresenter implements EditDiscContract.Presenter {

    DiscDao discDao;
    EditDiscContract.View view;

    public AddDiscPresenter(EditDiscContract.View view1, DiscDao discDao1) {
        this.view = view1;
        view.setPresenter(this);
        this.discDao=discDao1;
    }

    @Override
    public void save(Disc disc) {
       long ids = discDao.insert(disc);
        System.out.println("THIS IS IDS:     @@@@@@@@@     "+ids);
        System.out.println(discDao.getAll());
        System.out.println("HELLO WORLD!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        view.close();
    }

    @Override
    public boolean validate(Disc disc) {
        return false;
    }

    @Override
    public void getDiscAndPopulate(long id) {
        Disc disc = discDao.findDisc(id);
        if (disc != null) {
            view.populate(disc);
        }
    }

    @Override
    public void update(Disc disc) {
        int ids = this.discDao.update(disc);
        view.close();
    }

    @Override
    public void start() {

    }
}