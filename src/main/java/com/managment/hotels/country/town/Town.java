package com.managment.hotels.country.town;

import com.managment.hotels.hotels.country.Country;
import com.managment.hotels.hotels.user.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "town")
public class Town implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    private String name;

    @JoinColumn(name = "id_country", referencedColumnName = "id")
    @ManytoOne(optional = false)
    private Country country;

    public Town() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(id, town.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
