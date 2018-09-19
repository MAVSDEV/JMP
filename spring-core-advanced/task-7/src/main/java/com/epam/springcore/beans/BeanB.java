package com.epam.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean B.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanB {

    private BeanA beanA;
}
