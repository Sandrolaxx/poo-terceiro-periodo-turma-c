package primeirobimestre.list7.service;

import primeirobimestre.list7.domain.domains.Loja;
import primeirobimestre.list7.repository.LojaRepository;

public class LojaService {
    private LojaRepository lojaRepository = new LojaRepository();
    private static long id = 1;

    public void cadastrarLoja(Loja loja) {
        if (loja == null) throw new NullPointerException();
        loja.setId(id++);
        lojaRepository.cadastrarLoja(loja);
    }

    public void printListLojas() {
        lojaRepository.printListLojas();
    }

    public Loja findByIdOrThrowIllegalArgumentException(Long id) {
        return lojaRepository.findByIdOrThrowIllegalArgumentException(id);
    }
}