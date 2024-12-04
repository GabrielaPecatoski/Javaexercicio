
public class Livro {
    private String titulo;
    private String autor;
    private int numeroDePaginas;
    private int paginaAtual;

    public Livro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        if (numeroDePaginas > 0) {
            this.numeroDePaginas = numeroDePaginas;
        } else {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
        this.paginaAtual = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        if (paginaAtual >= 0 && paginaAtual <= numeroDePaginas) {
            this.paginaAtual = paginaAtual;
        } else {
            throw new IllegalArgumentException("Página atual deve estar entre 0 e " + numeroDePaginas);
        }
    }

    public void abrir() {
        System.out.println("O livro "" + titulo + "" foi aberto.");
    }

    public void lerPagina() {
        if (paginaAtual < numeroDePaginas) {
            paginaAtual++;
            System.out.println("Você leu a página " + paginaAtual);
        } else {
            System.out.println("Você já terminou o livro!");
        }
    }
}
