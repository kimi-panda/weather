package net.limonova.weather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City extends AbstractNamedEntity {

    @Column(name = "code_gismeteo")
    private String codeGismeteo;

    public City() {
    }

    public City(Integer id, String name, String codeGismeteo) {
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
        return "City{" +
                "codeGismeteo=" + codeGismeteo +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
