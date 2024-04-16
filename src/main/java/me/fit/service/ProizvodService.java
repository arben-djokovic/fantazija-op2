package me.fit.service;

import java.util.List;
import java.util.HashSet;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.exception.ProizvodException;
import me.fit.exception.ProizvodStatus;
import me.fit.model.Proizvod;

@Dependent
public class ProizvodService {

    @Inject
    private EntityManager em;

    @Transactional
    public Proizvod createProizvod(Proizvod proizvod) throws ProizvodException {
        List<Proizvod> proizvodi = getAllProizvodi();

        if (proizvodi.contains(proizvod)) {
            throw new ProizvodException(ProizvodStatus.EXISTS.getLabel());
        }

        return em.merge(proizvod);
    }

    @Transactional
    public List<Proizvod> getAllProizvodi() {
        List<Proizvod> proizvodi = em.createNamedQuery(Proizvod.GET_ALL_PROIZVODI, Proizvod.class).getResultList();

        return proizvodi;
    }

    @Transactional
    public List<Proizvod> getProizvodiByIme(String ime) {
        List<Proizvod> proizvodi = em.createNamedQuery(Proizvod.GET_PROIZVODI_BY_IME, Proizvod.class)
                .setParameter("ime", ime).getResultList();


        return proizvodi;
    }
}
