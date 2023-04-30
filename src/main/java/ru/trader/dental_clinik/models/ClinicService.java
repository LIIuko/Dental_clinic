package ru.trader.dental_clinik.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "clinikServices")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ClinicService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @ManyToMany(mappedBy = "clinicServices", fetch = FetchType.LAZY)
    private List<Dentist> dentists;
}
