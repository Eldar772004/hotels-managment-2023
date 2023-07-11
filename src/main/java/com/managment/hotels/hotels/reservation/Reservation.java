package com.managment.hotels.hotels.reservation;

import com.managment.hotels.guest.Guest;
import com.managment.hotels.hotels.user.*;
import com.managment.hotels.reservation.room.Room;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_guest",referencedColumnName = "id")
    @ManytoOne(optional = false)
    private Guest mainGuest;

    @JoinColumn(name = "id_room",referencedColumnName = "id")
    @ManytoOne(optional = false)
    private Room room;
    @Basic(optional = false)
    @Column(name = "from_date")
    private LocalDateTime fromDate;

    @Basic(optional = false)
    @Column(name = "to_date")
    private LocalDateTime toDate;
    @Basic(optional = false)
    private Boolean checkin;


    @Basic(optional = false)
    @Column(name = "checkin_date_time")
    private LocalDateTime checkinDateTime;

    @Basic(optional = false)
    private Boolean checkout;

    @Basic(optional = false)
    @Column(name = "checkout_date_time")
    private LocalDateTime checkoutDateTime;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
