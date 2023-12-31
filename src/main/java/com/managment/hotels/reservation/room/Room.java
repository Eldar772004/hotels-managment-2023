package com.managment.hotels.reservation.room;

import com.managment.hotels.hotels.privilege.OneToMany;
import com.managment.hotels.hotels.reservation.GenerationType;
import com.managment.hotels.hotels.user.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "room")
@NamedQueries()
public class Room implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    private String code;

    @Basic(optional = false)
    @Column(name = "number_of_beds")
    private int numberOfBeds;

    @Basic(optional = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservationList;

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
