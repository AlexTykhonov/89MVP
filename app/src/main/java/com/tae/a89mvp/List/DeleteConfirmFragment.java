package com.tae.a89mvp.List;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import com.tae.a89mvp.R;
import com.tae.a89mvp.Util.Constants;


public class DeleteConfirmFragment extends DialogFragment {

    private ListContract.DeleteListener mListener;

    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final long discId = getArguments().getLong(Constants.DISC_ID);
        // window dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //текст в окошке
        builder.setTitle(R.string.are_you_sure);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.setConfirm(true, discId);
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.setConfirm(false, discId);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (ListContract.DeleteListener) context;
    }
}
