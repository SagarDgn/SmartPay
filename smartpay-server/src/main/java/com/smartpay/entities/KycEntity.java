package com.smartpay.entities;

import com.smartpay.domain.KYC_STATUS;
import com.smartpay.domain.convertor.KycStatusConvertor;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

@MappedEntity
@Serdeable
@Introspected
@Getter
@Setter
public class KycEntity {

    @Id
    @GeneratedValue
    @MappedProperty("kyc_id")
    private Integer id;

    @MappedProperty("user_father")
    private String father_name;

    @MappedProperty("user_grandfather")
    private String grandfather_name;

    @MappedProperty("user_dob")
    private String date_of_birth;

    @MappedProperty("user_gender")
    private String gender;

    @MappedProperty("user_conactinfo")
    private Long contact_no;

    @MappedProperty
    private String occupation;

    @MappedProperty("current_address")
    private String current_address;

    @MappedProperty("permanent_address")
    private String permanent_address;

    @MappedProperty("citizenship_num")
    private Long citizenship_no;

    @MappedProperty("citizenship_picfront")
    private Long citizenshippic_front;

    @MappedProperty("citizenship_picback")
    private Long citizenshippic_back;

    @MappedProperty("national_idnum")
    private Long national_idnum;

    @MappedProperty("national_id_picfront")
    private Long nationalidpic_front;

    @MappedProperty("national_id_picback")
    private Long nationalidpic_back;

    @Relation(Relation.Kind.ONE_TO_ONE)
    private UserEntity user;

    @MappedProperty(value = "user_kyc_status",converter = KycStatusConvertor.class ,type = DataType.STRING)
    private KYC_STATUS kycStatus= KYC_STATUS.PENDING;
}
