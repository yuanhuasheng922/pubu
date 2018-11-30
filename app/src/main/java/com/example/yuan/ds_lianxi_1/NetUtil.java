package com.example.yuan.ds_lianxi_1;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Lenovo
 *
 */
public class NetUtil {

    private static NetUtil instance;

    public NetUtil(){

    }
    public static NetUtil getInstance() {
        if(instance==null){
            instance=new NetUtil();
        }
        return instance;
    }
    public interface Callback<T>{
        void onSuccess(T t);
    }


    public <T> T reQuest(String dataUrl,Class clazz){
        return (T) new Gson().fromJson(reQuest(dataUrl),clazz);
    }

    public void reQuest(final String dataUrl, final Class clazz, final Callback callback){
        new AsyncTask<String,Void,Object>(){
            @Override
            protected Object doInBackground(String... strings) {
                return reQuest(strings[0],clazz);
            }

            @Override
            protected void onPostExecute(Object o) {
                callback.onSuccess(o);
            }
        }.execute(dataUrl);
    }


    public String reQuest(String dataUrl){
        String result="";
        try {
            URL url=new URL(dataUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(3000);
            urlConnection.setConnectTimeout(3000);
            int responseCode = urlConnection.getResponseCode();
            if(responseCode==200){
                result=Stream2String(urlConnection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String Stream2String(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        for (String tmp=bufferedReader.readLine();tmp!=null;tmp=bufferedReader.readLine()){
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }
}
