package com.in28minutes.microservices.currencyexchangeservice.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_exchange_value")
public class ExchangeValue {
    @Id
    private String id;

    @Column(name = "from_currency")
    private String from;

    @Column(name = "to_currency")
    private String to;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Transient
    private int port;
}
