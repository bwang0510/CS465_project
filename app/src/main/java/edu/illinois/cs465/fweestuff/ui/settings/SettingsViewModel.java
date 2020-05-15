package edu.illinois.cs465.fweestuff.ui.settings;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {
    public void pickProfileImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
    // TODO: Implement the ViewModel
}
