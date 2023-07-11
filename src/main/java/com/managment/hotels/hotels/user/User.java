package com.managment.hotels.hotels.user;

import com.managment.hotels.hotels.privilege.Privilege;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "id")
@NamedQuery(name = "User.findByUsernamePass",
        query = "SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
public class User implements Serializable {
    @Id(name = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    private String username;
    @Basic(optional = false)
    private String password;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String surname;
    private Object FetchType;
    @JoinColumn(name = "id_privilege",referencedColumnName = "id")
    private Privilege privilege;

    public User(String usernameInput, String passwordInput, String nameInput, String surnameInput, com.managment.hotels.hotels.user.Privilege privilege) {
    }


    public User(Integer id, String username, String password, String name, String surname, Object fetchType, Privilege privilege) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        FetchType = fetchType;
        this.privilege = privilege;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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






    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Privilege getPrivilege() {
        return null;
    }
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
}
}
