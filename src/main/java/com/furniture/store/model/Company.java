package com.furniture.store.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(name = "company_seq", sequenceName = "company_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}