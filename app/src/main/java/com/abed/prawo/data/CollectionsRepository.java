package com.abed.prawo.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.abed.prawo.data.local.AppDatabase;
import com.abed.prawo.data.local.CollectionsDao;
import com.abed.prawo.data.models.Collection;

import java.util.List;

public class CollectionsRepository {

    private static final int INSERT = 0;
    private static final int UPDATE = 1;
    private static final int DELETE = 2;

    private CollectionsDao dao;
    private LiveData<List<Collection>> collections;

    public CollectionsRepository(Application application) {
        dao = AppDatabase.getDatabase(application).collectionsDao();
        collections = dao.getAll();
    }

    public LiveData<List<Collection>> getAllCollections() {
        return collections;
    }

    public void insertCollection(Collection collection) {
        new Task(dao, INSERT).execute(collection);
    }

    public void updateCollection(Collection collection) {
        new Task(dao, UPDATE).execute(collection);
    }

    public void deleteCollection(Collection collection) {
        new Task(dao, DELETE).execute(collection);
    }

    private static class Task extends AsyncTask<Collection, Void, Void> {
        private CollectionsDao asyncDao;
        private int operation;

        Task(CollectionsDao dao, int operation) {
            asyncDao = dao;
            this.operation = operation;
        }

        @Override
        protected Void doInBackground(Collection... collections) {
            switch (operation) {
                case INSERT:
                    asyncDao.insert(collections[0]);
                case UPDATE:
                    asyncDao.update(collections[0]);
                case DELETE:
                    asyncDao.delete(collections[0]);
            }
            return null;
        }
    }
}
