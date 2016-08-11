
package yi.music.util;

import android.util.Log;

public class LogUtil {

    private final static String TAG = "yi-music";

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void w(String msg, Throwable tr) {
        Log.w(TAG, msg, tr);
    }

}
