package demo.CobaDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import demo.CobaDemo.entity.EPegawai;
import demo.CobaDemo.pojo.PPegawai;
import demo.CobaDemo.repositories.RPegawai;
import demo.CobaDemo.service.SPegawai;
import demo.CobaDemo.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CPegawai {

    @Autowired
//    private RPegawai rPegawai;
    private SPegawai sPegawai;

    // GET Success
    /*@GetMapping("/getpegawai")
    public List<EPegawai> getAllPegawai(){
        return rPegawai.findAll();
    }*/

    // Try new Get with Service
    @GetMapping("/getpegawai")
    public ApiResponse get(@RequestParam(required = false) Long id) throws JsonProcessingException {
        PPegawai pPegawai = sPegawai.getAllPegawai(id);
        return ApiResponse.data("item", pPegawai);
    }

//    @PostMapping("/getpegawai")
//    public EPegawai createPegawai(@RequestBody EPegawai ePegawai) {
//        return rPegawai.save(ePegawai);
//    }

}
