package br.com.pdv7.saidacomanda.Business;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import br.com.pdv7.saidacomanda.RetrofitConfig;
import br.com.pdv7.saidacomanda.dominios.FecharComanda;
import br.com.pdv7.saidacomanda.dominios.SaldoComanda;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComandaBusiness extends AppCompatActivity {

    Context context;

    public ComandaBusiness(Context c){
        context = c;
    }
    public void FecharComanda(int idPedido){

        final RetrofitConfig retrofit = new RetrofitConfig();

        FecharComanda fecharComanda = new FecharComanda();

        fecharComanda.IDPedido = idPedido;
        fecharComanda.IDPdv = 1;
        fecharComanda.ChaveAcesso = "2010";
        fecharComanda.GerarOrdemProducao = false;
        fecharComanda.DocNfe = "37966526895";
        fecharComanda.DocFidelidade = "1";
        fecharComanda.Cancelar = false;
        fecharComanda.ImagemComprovante = 0;

        Call<Void> callFechar = retrofit.Service.Fechar(idPedido, fecharComanda);

        callFechar.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                    }
        });
    }

    public void ConsultaComanda(EditText numeroComanda) {

        RetrofitConfig retrofit = new RetrofitConfig();

        retrofit.Service.Saldo(Integer.parseInt(numeroComanda.getText().toString())).enqueue(new Callback<SaldoComanda>() {
            @Override
            public void onResponse(Call<SaldoComanda> call, Response<SaldoComanda> response) {
                int statusCode = response.code();
                SaldoComanda comanda = response.body();

                if (statusCode == 404) {

                    alerta("Comanda não Existe!");
                } else {
                    if (comanda.status == 10) {
                        alerta("Comanda Liberada!");
                        return;
                    }
                    if (comanda.status == 20) {
                        if (comanda.ValorTotal - comanda.ValorPago == 0) {
                            alertaFechar("Comanda Zerada. Deseja Fechar?", comanda.idPedidoAberto);
                            return;
                        } else {
                            double pendente = comanda.ValorTotal - comanda.ValorPago;
                            alerta("Comanda com valor pendente de: " + String.valueOf(pendente));
                            return;
                        }
                    }
                    if (comanda.status == 30) {
                        alerta("Comanda Cancelda");
                        return;
                    }
                    if (comanda.status == 40) {
                        alerta("Comanda Perdida");
                        return;
                    }
                    if(comanda.status == 50){
                        alerta("Comanda com Conta Solicitada");
                        return;
                    }
                }
            }

            @Override
            public void onFailure(Call<SaldoComanda> call, Throwable t) {
                alerta(t.toString());
            }
        });
    }

    public void alerta (String resultado){

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Atenção!");
        alertDialog.setMessage(resultado);
        alertDialog.show();
    }

    public void alertaFechar(String resultado, final int idPedido) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Resultado")
                .setMessage(resultado)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FecharComanda(idPedido);
                    }
                })
                .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
