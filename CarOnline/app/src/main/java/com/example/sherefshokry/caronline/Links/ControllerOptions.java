package com.example.sherefshokry.caronline.Links;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public interface ControllerOptions {

    public abstract String[] connect(String ... params);
    public abstract void connReturn(String result) throws JSONException;

}
