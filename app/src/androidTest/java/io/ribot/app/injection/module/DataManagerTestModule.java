package io.ribot.app.injection.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.ribot.app.data.local.DatabaseHelper;
import io.ribot.app.data.local.PreferencesHelper;
import io.ribot.app.data.remote.RibotsService;
import io.ribot.app.injection.scope.PerDataManager;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.mock;

/**
 * Provides dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary
 */
@Module
public class DataManagerTestModule {

    private final Context mContext;

    public DataManagerTestModule(Context context) {
        mContext = context;
    }

    @Provides
    @PerDataManager
    DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper(mContext);
    }

    @Provides
    @PerDataManager
    PreferencesHelper providePreferencesHelper() {
        return new PreferencesHelper(mContext);
    }

    @Provides
    @PerDataManager
    RibotsService provideRibotsService() {
        return mock(RibotsService.class);
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.immediate();
    }
}
