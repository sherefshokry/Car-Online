package com.example.sherefshokry.caronline.Controllers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;

import com.example.sherefshokry.caronline.Links.ControllerOptions;
import com.example.sherefshokry.caronline.R;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Sheref Shokry on 8/2/2016.
 */
public class Controller {
    private static Controller controller;
    private static ControllerOptions option;

    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }

    private Controller() {

    }


    public static ControllerOptions getOption() {
        return option;
    }
    public static void setOption(ControllerOptions option) {
        Controller.option = option;
    }


    public void execute(Context context,ControllerOptions op, String ... params) {
        option = op;
        String[] URL = option.connect(params);
        new Connection(context).execute(URL);
    }


    private class Connection extends AsyncTask<String, String, String> {
        public Context myContext = null;
        private int check;
        public Connection(Context con) {

            check = 0;
            myContext = con;
        }
       private ProgressDialog dialog;


        @Override
        protected String doInBackground(String... params) {
            URL url;

            String urlParameters = params[1];

            HttpURLConnection connection;
            try {
                url = new URL(params[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setInstanceFollowRedirects(false);
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(60000); // 60 Seconds
                connection.setReadTimeout(60000); // 60 Seconds

                connection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded;charset=UTF-8");
                OutputStreamWriter writer = new OutputStreamWriter(
                        connection.getOutputStream());
                writer.write(urlParameters);
                writer.flush();

                String line, retJson = "";
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    retJson += line;
                }

                return retJson;

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }

        protected void onPreExecute() {


            if (check == 0) {
                dialog = new ProgressDialog(myContext);
                this.dialog.setMessage("Loading data ,Please Wait ...");
                this.dialog.show();
            }
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (check == 0) {
                if (dialog.isShowing())
                    dialog.dismiss();
            }

            try {
                option.connReturn(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }
}
