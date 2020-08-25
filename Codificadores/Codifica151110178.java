package Codificadores;

public class Codifica151110178 implements Codifica {
  @Override
  public String getNomeAutor() {
    return "Bruno Ribeiro Teixeira";
  }

  @Override
  public String getMatriculaAutor() {
    return "15111017-8";
  }

  @Override
  public String codifica(String entradaPlainText) {
    int ascCode;
    for (int i = 0; i < entradaPlainText.length(); i++) {
      ascCode = entradaPlainText.charAt(i);
      entradaPlainText.replace(entradaPlainText.charAt(i), (char) ascCode++);
    }
    return entradaPlainText;
  }

  @Override
  public String decodifica(String entradaCodificada) {
    int ascCode;
    for (int i = 0; i < entradaCodificada.length(); i++) {
      ascCode = entradaCodificada.charAt(i);
      entradaCodificada.replace(entradaCodificada.charAt(i), (char) ascCode--);
    }
    return entradaCodificada;
  }
}