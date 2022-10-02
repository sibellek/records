package personal.records.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;
    private short ISOCode;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Person> people;
    public Country(String name, short ISOCode) {
        this.name = name;
        this.ISOCode = ISOCode;
    }

    public Country(Country countryRequest) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getISOCode() {
        return ISOCode;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setISOCode(short ISOCode) {
        this.ISOCode = ISOCode;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
