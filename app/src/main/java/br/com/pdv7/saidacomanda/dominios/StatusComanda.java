package br.com.pdv7.saidacomanda.dominios;

import com.google.gson.annotations.SerializedName;

public class StatusComanda {

    @SerializedName("status")
    public int status;

    @SerializedName("idPedidoAberto")
    public int idPedidoAberto;
}
