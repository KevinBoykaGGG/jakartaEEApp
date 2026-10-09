/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.samples.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import com.microsoft.azure.samples.entities.*;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@Transactional(REQUIRED)
@RequestScoped
public class CityService {

    @PersistenceContext(unitName = "JPAWorldDatasourcePU")
    EntityManager em;

    @Transactional(SUPPORTS)
    public List<City> findOver1MillPopulation(String countrycode) {
        TypedQuery<City> query = em.createNamedQuery("City.findOver1MillPopulation", City.class);
        query.setParameter("countrycode", countrycode);
        return query.getResultList();
    }
     @Transactional(SUPPORTS)
    public List<City> findByName(String name) {
        TypedQuery<City> query = em.createNamedQuery("City.findByName", City.class);
        query.setParameter("name", name);
        return query.getResultList();
     }
     @Transactional(SUPPORTS)
     public List<City> allCities() {
        TypedQuery<City> query = em.createNamedQuery("City.findAll", City.class);
        return query.getResultList();
     }
     @Transactional
     public List<String> findByPopulation(int population) {
        TypedQuery<String> query = em.createNamedQuery("City.findByPopulation", String.class);
        query.setParameter("population", population);
        return query.getResultList();
     }
}
