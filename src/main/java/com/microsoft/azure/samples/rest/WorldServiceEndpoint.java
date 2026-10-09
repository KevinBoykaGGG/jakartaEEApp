/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.samples.rest;

import java.util.List;

import com.microsoft.azure.samples.services.CityService;
import com.microsoft.azure.samples.services.CountryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.microsoft.azure.samples.entities.City;
import com.microsoft.azure.samples.entities.Country;

@Path("/")
public class WorldServiceEndpoint {
    @Inject
    CountryService countrySvc;

    @Inject
    CityService citySvc;

    @GET
    @Path(value = "/area")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllContinents() {
        List<String> continents = countrySvc.findAllContinents();
        return Response.ok(continents, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/area/{continent}")
    public Response getContinent(@PathParam("continent") String continent) {
        List<Country> country = countrySvc.findItemByContinent(continent);
        GenericEntity<List<Country>> genericEntity = new GenericEntity<List<Country>>(country) {
        };
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/countries/{countrycode}")
    public Response getCountry(@PathParam("countrycode") String countrycode) {
        List<City> city = citySvc.findOver1MillPopulation(countrycode);
        GenericEntity<List<City>> genericEntity = new GenericEntity<List<City>>(city) {
        };
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("city/{name}")
    public Response getCityByName(@PathParam("name") String name) {
        List<City> cities = citySvc.findByName(name);
        GenericEntity<List<City>> genericEntity = new GenericEntity<>(cities) {};
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Cities")
    public Response getAllCities(){
        List<City> cities = citySvc.allCities();
        return Response.ok(cities, MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities/{population}")
    public Response getByPopulation (@PathParam("population") int population) {
        List<String> cities = citySvc.findByPopulation(population);
        if(cities.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(cities, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/country/{population}")
    public Response getCountiesByPopulation(@PathParam("population") int population) {
        List<Country> countries = countrySvc.findByPopulation(population);
        if(countries.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(countries, MediaType.APPLICATION_JSON).build();
    }
}