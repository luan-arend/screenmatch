package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private String titulo;
    private Integer numero;
    private Double avaliacao;
    private LocalDate dataLancamento;
    private Integer temporada;

    public Episodio(Integer numeroTemporada, DadosEpisodio d) {
        this.temporada = numeroTemporada;
        this.titulo = d.titulo();
        this.numero = d.numero();
        try {
            this.avaliacao = Double.valueOf(d.avaliacao());
        } catch (NumberFormatException e) {
            this.avaliacao = 0.0;
        }
        try {
            this.dataLancamento = LocalDate.parse(d.dataLancamento());
        } catch (DateTimeParseException e) {
            this.dataLancamento = null;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "titulo='" + titulo + '\'' +
                ", numero=" + numero +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                ", temporada=" + temporada +
                '}';
    }
}
