package net.i2p.android.router.addressbook;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import net.i2p.android.wizard.model.AbstractWizardModel;
import net.i2p.android.wizard.ui.AbstractWizardActivity;

public class AddressbookAddWizardActivity extends AbstractWizardActivity {
    @Override
    protected AbstractWizardModel onCreateModel() {
        return new AddressbookAddWizardModel(this);
    }

    @Override
    protected DialogFragment onGetFinishWizardDialog() {
        return new DialogFragment() {
            @NonNull
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                return new AlertDialog.Builder(getActivity())
                        .setMessage("Add to private addressbook?")
                        .setPositiveButton("Add",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent result = new Intent();
                                        setResult(Activity.RESULT_OK, result);
                                        result.putExtra(AddressbookContainer.ADD_WIZARD_DATA, mWizardModel.save());
                                        dialog.dismiss();
                                        finish();
                                    }
                                })
                        .setNegativeButton(android.R.string.cancel, null)
                        .create();
            }
        };
    }
}
