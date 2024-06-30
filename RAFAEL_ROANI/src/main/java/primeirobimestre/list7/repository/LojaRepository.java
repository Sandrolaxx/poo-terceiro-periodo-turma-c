package primeirobimestre.list7.repository;

import primeirobimestre.list7.domain.domains.Loja;

import java.util.HashMap;
import java.util.Map;

public class LojaRepository {
    private static final Map<Long, Loja> LOJAS_CADASTRADAS = new HashMap<>();

    public synchronized void cadastrarLoja(Loja loja) {
        LOJAS_CADASTRADAS.put(loja.getId(), loja);
    }

    public void printListLojas() {
        if(LOJAS_CADASTRADAS.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada!");
            return;
        }
        LOJAS_CADASTRADAS.forEach((k, v) -> System.out.println(v));
    }

    public Loja findByIdOrThrowIllegalArgumentException(Long id) {
        try {
            return LOJAS_CADASTRADAS.get(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("ERRO! O item selecionado não existe!");
        }
    }
}