package com.example.springjpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name="ID_SEQ", initialValue = 1000)
@Getter
@Setter
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    private Long customerId;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Address> addressSet = new HashSet<>();

    public Customer addAddress(Address address) {
        address.setCustomer(this);
        if (this.addressSet == null) {
            this.addressSet = new HashSet<>();
        }
        this.addressSet.add(address);
        return this;
    }
}
