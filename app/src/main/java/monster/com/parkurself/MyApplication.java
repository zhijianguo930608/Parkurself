package monster.com.parkurself;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 10/5/2015.
 */
public class MyApplication extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
