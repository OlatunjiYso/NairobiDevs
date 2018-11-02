package com.olatunji.nairobijavadev.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkConnection {
    private NetworkConnection() {
        // Left blank intentionally.
    }
    public static boolean connectionStatus(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork == null) {
            return false;
        }

        return  activeNetwork != null
                &&
                activeNetwork.isConnectedOrConnecting()
                &&
                activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
                        ||
                        activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
    }
}
