// https://www.devmedia.com.br/consumindo-json-em-aplicacoes-android/27589

package br.com.pdv7.saidacomanda;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import br.com.pdv7.saidacomanda.interfaces.JsonComplet;


public class DownloadJsonAsyncTask extends AsyncTask<String, Void, String> {

    JsonComplet pronto;

    public DownloadJsonAsyncTask(JsonComplet ok)
    {
        pronto = ok;
    }

    @Override
    protected String doInBackground(String... params) {
        String urlString = params[0];

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(urlString);

        try {
            HttpResponse response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();

                String json = toString(instream);
                instream.close();

                return json;

            }
        } catch (Exception e) {
            Log.e("DEVMEDIA", "Falha ao acessar Web service", e);
        }
        return null;
    }

    private String toString(InputStream is) throws IOException {

        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        pronto.JsonCompleto(result);
    }





}
