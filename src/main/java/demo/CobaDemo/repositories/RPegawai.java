package demo.CobaDemo.repositories;

import demo.CobaDemo.entity.EPegawai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RPegawai extends SimpleJpaRepository<EPegawai, Long> {

    protected final EntityManager em;

    public RPegawai(EntityManager em) {
        super(EPegawai.class, em);
        this.em = em;
    }

    public EPegawai getAllPegawai(Long id) {
        String query = "Select e from EPegawai e";

        try {
            return em.createQuery(query, EPegawai.class)
//                    .setParameter()
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
