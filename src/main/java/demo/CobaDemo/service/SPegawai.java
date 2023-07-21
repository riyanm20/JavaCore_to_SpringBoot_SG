package demo.CobaDemo.service;

import demo.CobaDemo.pojo.PPegawai;
import demo.CobaDemo.repositories.RPegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sPegawai")
public class SPegawai {

    @Autowired
    private RPegawai rPegawai;

    public PPegawai getAllPegawai(Long id) {

        return PPegawai.fromEntity(rPegawai.getAllPegawai(id));

    }

}
