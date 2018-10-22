package br.com.pdv7.saidacomanda.interfaces;

import br.com.pdv7.saidacomanda.dominios.FecharComanda;
import br.com.pdv7.saidacomanda.dominios.SaldoComanda;
import br.com.pdv7.saidacomanda.dominios.StatusComanda;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceRetrofit {

    @GET("api/comandas/{numero}/status")
    Call<StatusComanda> Status(@Path("numero")int numero);

    @GET("api/comandas/{numero}/saldo")
    Call<SaldoComanda> Saldo (@Path("numero")int numero);

    @POST("api/pedidos/{id}/fechar")
    Call<Void> Fechar (@Path("id") int id ,@Body FecharComanda fecharComanda);

}
