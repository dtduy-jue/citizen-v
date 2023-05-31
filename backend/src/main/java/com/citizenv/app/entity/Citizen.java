package com.citizenv.app.entity;

import com.citizenv.app.component.Utils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "citizens")
@Getter
@Setter
@RequiredArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nationalId;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    /*Tuổi của công dân, tự động tính khi Getter của Citizen được gọi*/
    @Transient
    private Integer age;
    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    private String bloodType;

    private String sex;

    private String maritalStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ethnicity_id", nullable = false)
    private Ethnicity ethnicity;

    private String otherNationality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "religion_id")
    private Religion religion;

    private String job;

    private String educationalLevel;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    private List<Address> addresses;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    private List<Association> associations;

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' +
                ", sex='" + sex + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", ethnicity=" + ethnicity +
                ", otherNationality='" + otherNationality + '\'' +
                ", religion=" + religion +
                ", job='" + job + '\'' +
                ", educationalLevel='" + educationalLevel + '\'' +
                '}';
    }
}
