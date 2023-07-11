package com.managment.hotels.guest;

import com.managment.hotels.country.town.address.Address;
import com.managment.hotels.hotels.privilege.OneToMany;
import com.managment.hotels.hotels.user.*;
import com.managment.hotels.reservation.room.Reservation;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="guest")
public class Guest implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    private String document;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String surname;

    @OneToMany(mappedBy = "mainGuest")
    private List<Reservation> reservationList;

    @JoinColumn(name = "id_address", referencedColumnName = "id")
    @ManytoOne(optional = false)
    private Address address;

    public Guest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
