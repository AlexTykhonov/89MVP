package com.tae.a89mvp.List;

import android.support.v7.util.DiffUtil;

import com.tae.a89mvp.BasePresenter;
import com.tae.a89mvp.BaseView;
import com.tae.a89mvp.DB.Disc;

import java.util.ArrayList;
import java.util.List;
// основной интерфейс
public interface ListContract {
    // вложенный интерфейс наследует БейсПрезентер
    interface Presenter extends BasePresenter {
        //метод аддДиск
        void addDisc();
        // метод возвращает результат по запросу и результату
        void result(int requestCode, int resultCode);
        //вывод списка дисков
        void populateDisc();
        //открыть активити АддДискАктивити
        void openAddDiscActivity(Disc disc);
        // открываем окно подтверждения удаления
        void openConfirmDeleteDialog(Disc disc);
        //удаляем диск
        void delete(long discId);
    }
    // Вью
    interface View extends BaseView<Presenter> {
        // переход в экран ввода нового диска
        void showAddDisc();
        //метод делает невидимым поле текста для пустого списка и добавляет туда значение всего списка дисков
        void setDiscs(List<Disc> discs);
        // показать экран редактирования
        void showEditScreen(long id);
        //показать экран подтверждения удаления
        void showDeleteConfirmDialog(Disc disc);
        // показать сообщение о пустом контенте
        void showEmptyMessage();
    }
    // методы обработки нажатия на экран
    interface OnItemClickListener {
        // обработка обычного нажатия
        void clickItem(Disc disc);
        //обработка длинного нажатия на экран
        void clickLongItem(Disc disc);
    }
    // подтверждение удаления
    interface DeleteListener {
        // подтвердить что было согласие на удаление
        void setConfirm(boolean confirm, long id);

    }
}