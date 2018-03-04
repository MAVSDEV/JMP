package com.epam.springcore.beans;

import lombok.Data;

/**
 * Bean C.
 */
@Data
public abstract class BeanC {

    abstract BeanD getBeanD();
}
