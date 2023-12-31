package com.managment.hotels.hotels.country;

import com.managment.hotels.country.town.Town;
import com.managment.hotels.hotels.privilege.OneToMany;
import com.managment.hotels.hotels.user.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Town> townList;

    public Country() {
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

    public List<Town> getTownList() {
        return townList;
    }

    public void setTownList(List<Town> townList) {
        this.townList = townList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
