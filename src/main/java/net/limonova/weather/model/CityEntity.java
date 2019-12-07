package net.limonova.weather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class CityEntity extends AbstractNamedEntity {

    @Column(name = "code_gismeteo")
    private String codeGismeteo;

    public CityEntity() {
    }

    public CityEntity(Integer id, String name, String codeGismeteo) {
        super(id, name);
        this.codeGismeteo = codeGismeteo;
    }

    public String getCodeGismeteo() {
        return codeGismeteo;
    }

    public void setCodeGismeteo(String codeGismeteo) {
        this.codeGismeteo = codeGismeteo;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "codeGismeteo=" + codeGismeteo +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
