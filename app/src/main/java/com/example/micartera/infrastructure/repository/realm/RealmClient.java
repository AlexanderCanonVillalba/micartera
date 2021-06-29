package com.example.micartera.infrastructure.repository.realm;

import android.app.Application;

import com.example.micartera.infrastructure.repository.realm.model.AccountRealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmClient extends Application {

    private static final String REALM_DATA_BASE_NAME = "test.realm";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(REALM_DATA_BASE_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
