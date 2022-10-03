package com.tic.vacupet.pets.domain;

import com.tic.vacupet.pets.owner.domain.Owner;
import com.tic.vacupet.vaccines.domain.Vaccine;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 30, message = "{pet.breed.length}")
    private String breed;

    @Length(max = 30, message = "{pet.name.length}")
    private String name;

    @NotNull(message = "{pet.birth_date.notnull}")
    private Date birthDate;

    private boolean hasChip;
    private boolean hasMedicalRecord;
    private boolean hasAllergies;

    @Length(max = 250, message = "{pet.observations.length}")
    private String observations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pet_owner"))
    private Owner owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pet_vaccine", joinColumns = @JoinColumn(name = "pet_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pet_vaccine_pet")), inverseJoinColumns = @JoinColumn(name = "vaccine_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_pet_vaccine_vaccine")))
    @ToString.Exclude
    private List<Vaccine> vaccines;
}
