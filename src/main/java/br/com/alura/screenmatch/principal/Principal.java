package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=94094c90";

    public void exibeMenu() {
        System.out.println("Digite o nome da série de busca:");
        String nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> dadosTemporadas = new ArrayList<>();
        for (int i = 1; i < dados.totalTemporadas(); i++) {
            json = consumo.obterDados(
                    ENDERECO + nomeSerie.replace(" ", "+")
                            + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            dadosTemporadas.add(dadosTemporada);
        }
        dadosTemporadas.forEach(System.out::println);


    }

//
//        System.out.println(dados);
//    json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//    DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);

}
