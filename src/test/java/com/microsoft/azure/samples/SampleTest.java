package com.microsoft.azure.samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.microsoft.azure.samples.entities.City;
import com.microsoft.azure.samples.services.CityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Habilita la integración de Mockito con JUnit 5
@ExtendWith(MockitoExtension.class)
public class SampleTest {

    // 1. Creamos un "mock" (un objeto simulado) del repositorio o dependencia que va a la base de datos
    @Mock
    private City cityRepository;

    // 2. Inyectamos los mocks automáticamente en la clase que queremos probar
    @InjectMocks
    private CityService cityService;

    @Test
    public void testGetCitiesCount() {
        // ARRANGE: Definimos qué queremos que devuelva el mock cuando se le llame
       // List<String> ciudadesFalsas = Arrays.asList("Monterrey", "Ciudad de México");
        //when(cityRepository.findAllCityNames()).thenReturn(ciudadesFalsas);

        // ACT: Ejecutamos el método real del servicio que queremos probar
       // int totalCiudades = cityService.obtenerCantidadDeCiudades();

        // ASSERT: Verificamos que el resultado sea el esperado
       // assertEquals(2, totalCiudades);
    }
}