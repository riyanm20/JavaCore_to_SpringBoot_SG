package demo.CobaDemo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import demo.CobaDemo.entity.EPegawai;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.ALWAYS)
public class PPegawai {

    public long id;
    public String fullName;
    public String emailAddress;

    public EPegawai toEntity() {

        EPegawai entity = new EPegawai();

        entity.setId(id);
        entity.setFullName(fullName);
        entity.setEmailAddress(emailAddress);

        return entity;

    }

    public static PPegawai fromEntity(EPegawai entity) {

        if (entity == null) return null;

        PPegawai pojo = null;
        pojo = new PPegawai();

        pojo.id = entity.getId();
        pojo.fullName = entity.getFullName();
        pojo.emailAddress = entity.getEmailAddress();

        return pojo;
    }

    public static List<PPegawai> fromEntities(List<EPegawai> entities) {
        if (entities == null) return new ArrayList<>();

        List<PPegawai> pojos = new ArrayList<>();

        for (EPegawai entity : entities) {
            pojos.add(PPegawai.fromEntity(entity));
        }
        return pojos;
    }

}
