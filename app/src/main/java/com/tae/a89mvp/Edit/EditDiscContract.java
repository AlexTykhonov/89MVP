package com.tae.a89mvp.Edit;

import com.tae.a89mvp.BasePresenter;
import com.tae.a89mvp.BaseView;
import com.tae.a89mvp.DB.Disc;

public interface EditDiscContract {


        interface Presenter extends BasePresenter {

            void save(Disc disc);

            boolean validate(Disc disc);

            void getDiscAndPopulate(long id);

            void update(Disc disc);
        }

        interface View extends BaseView<Presenter> {

            void showErrorMessage(int field);

            void clearPreErrors();

            void close();

            void populate(Disc disc);
        }

    }
