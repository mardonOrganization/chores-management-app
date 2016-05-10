package com.application.choresmanagement.context;

/**
 * Created by m.suma on 04/02/2016.
 */
public class Context {

    private static Context mContext;

    public Context() {
        if (mContext == null) {
            mContext = new Context();
        }
    }
}
