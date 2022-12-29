package com.atmostadam.cats.api.entity;

import com.atmostadam.cats.api.model.Cat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "cat_table")
@NamedQuery(name = "CatTable.queryByMicrochipNumber", query = "FROM CatEntity WHERE microchipNumber = :microchipNumber")
@Getter
@Setter
@Accessors(fluent = false, chain = true)
public class CatEntity {
    @Id
    @Column(name = "microchip_number")
    private Long microchipNumber;

    private String name;

    private String breed;

    private String type;

    @Column(name = "primary_color")
    private String primaryColor;

    private String sex;

    private Integer age;

    private Boolean neutered;

    private Boolean deceased;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timestamp")
    private Timestamp updatedTimestamp;

    public Cat newCat() {
        return new Cat()
                .setMicrochipNumber(microchipNumber)
                .setName(name)
                .setBreed(breed)
                .setType(type)
                .setPrimaryColor(primaryColor)
                .setSex(sex)
                .setAge(age)
                .setNeutered(neutered)
                .setDeceased(deceased);
    }
}
