package br.com.pdv7.saidacomanda.dominios;

import com.google.gson.annotations.SerializedName;

public class SaldoComanda {

    @SerializedName("status")
    public int status;

    @SerializedName("idPedidoAberto")
    public int idPedidoAberto;

    @SerializedName("ValorTotal")
    public double ValorTotal;

    @SerializedName("ValorPago")
    public double ValorPago;

    @SerializedName("ValorServico")
    public double ValorServico;

    @SerializedName("ClienteNome")
    public String ClienteNome;

    @SerializedName("ClienteDocumento")
    public String ClienteDocumento;

    @SerializedName("DocumentoFiscal")
    public String DocumentoFiscal;

    @SerializedName("Limite")
    public double Limite;
}
