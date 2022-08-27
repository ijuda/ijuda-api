package br.com.ijuda.api.model.enumeration;

public enum StatusSolicitacao {

    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    PAGO("Pago"),
    SOLICITADO("Solicitado"),
    EM_PROCESSO("Em processo");

    private String label;

    StatusSolicitacao(String label) {
        this.label = label;
    }

    public static String getLabelByOrdinal(Long paramentro){
        try{
            return StatusSolicitacao.values()[paramentro.intValue()].label;
        } catch (ArrayIndexOutOfBoundsException exception){
            return "Tipo nao implementado";
        }
    }

    public String getLabel(){
        return label;
    }
}
