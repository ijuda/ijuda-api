package br.com.ijuda.api.model.enumeration;

public enum Categoria {

    ASSISTENCIA_TECNICA("Assistência Técnica"),
    AULAS("Aulas"),
    AUTOS("Autos"),
    CONSULTORIA("Consultoria"),
    DESIGN_E_TECNOLOGIA("Design e Tecnologia"),
    EVENTOS("Eventos"),
    MODA_E_BELEZA("Moda e beleza"),
    REFORMAS_E_REPAROS("Reforma e reparos"),
    SAUDE("Saúde"),
    SERVICOS_DOMESTICOS("Serviços Domésticos");



    private String label;

    Categoria(String label) {
        this.label = label;
    }

    public static String getLabelByOrdinal(Long paramentro){
        try{
            return Categoria.values()[paramentro.intValue()].label;
        } catch (ArrayIndexOutOfBoundsException exception){
            return "Tipo nao implementado";
        }
    }

    public String getLabel(){
        return label;
    }
}
