package br.com.pdv7.saidacomanda.dominios;

import com.google.gson.annotations.SerializedName;

public class FecharComanda {

    @SerializedName("IDPedido")
    public int IDPedido;

    @SerializedName("IDPdv")
    public int IDPdv;

    @SerializedName("ChaveAcesso")
    public String ChaveAcesso;

    @SerializedName("DocNfe")
    public String DocNfe;

    @SerializedName("DocFidelidade")
    public String DocFidelidade;

    @SerializedName("GerarOrdemProducao")
    public Boolean GerarOrdemProducao;

    @SerializedName("Cancelar")
    public Boolean Cancelar;

    @SerializedName("ImagemComprovante")
    public int ImagemComprovante;
}
