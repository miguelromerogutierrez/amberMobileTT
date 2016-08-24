package com.escom.b074.amber.app.AsynTasks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;


public class HttpAsynTask <T> extends AsyncTask<String, Void, ResponseHolder<T>> {

    Context mContext;
    private AsyncStrategy<T> mStrategy;

    public HttpAsynTask(Context context, AsyncStrategy<T> strategy) {
        mContext = context;
        mStrategy = strategy;
    }

    @Override
    protected ResponseHolder<T> doInBackground(String... urls) {

        ResponseHolder<T> responseHolder = new ResponseHolder<>();

        ConnectivityManager connectivityManager =  (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {

            try {

                responseHolder.setResponse(mStrategy.execute());

            } catch (Exception exception) {

                exception.printStackTrace();

                String errorMessage = "Es necesario estar conectado a internet para continuar.";
                responseHolder.setErrorMessage(errorMessage);

            }

        } else {
            String errorMessage = "Es necesario estar conectado a internet para continuar.";
            responseHolder.setErrorMessage(errorMessage);
        }

        return responseHolder;
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(ResponseHolder<T> result) {
        super.onPostExecute(result);
        if (result.getResponse() != null) {
            mStrategy.handleResponse(result.getResponse());
        } else {
            mStrategy.handleError(result.getErrorMessage());
        }
    }

}
