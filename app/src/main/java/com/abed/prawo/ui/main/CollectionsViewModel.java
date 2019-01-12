package com.abed.prawo.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.abed.prawo.data.CollectionsRepository;
import com.abed.prawo.data.models.Collection;
import com.bumptech.glide.Glide;

import java.util.List;

class CollectionsViewModel extends AndroidViewModel {
    private CollectionsRepository repository;
    private LiveData<List<Collection>> collections;

    CollectionsViewModel(@NonNull Application application) {
        super(application);
        repository = new CollectionsRepository(application);
        collections = repository.getAllCollections();
    }

    LiveData<List<Collection>> getAllCollections() {
        return collections;
    }
}
