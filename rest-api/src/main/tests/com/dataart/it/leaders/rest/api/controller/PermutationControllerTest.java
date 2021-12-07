package com.dataart.it.leaders.rest.api.controller;


import com.dataart.it.leaders.rest.api.configuration.PermutationConfiguration;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.ResponseEntity;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


    /* @RunWith(SpringJUnit4ClassRunner.class)  -  Аннотация используется для настройки модульного теста, для которого требуется внедрение зависимостей Spring
                                Создание класса модульного теста Чтобы модульный тест запустил пакетное задание, фреймворк должен загрузить ApplicationContext задания.
                                 Для этого используются две аннотации:
                                 @RunWith()-Указывает, что класс должен использовать средства Spring
      @ContextConfiguration-указывает, какие файл Config  содержит ApplicationContext.
                              аннотация -одна из основных аннотаций загрузки Spring для загрузки контекста приложения:


                                        */
           /*  @SpringBootTest    -1. движок идёт по пакету вверх, пока не встретит класс, помеченный аннотацией @SpringBootConfiguration
           (как ни странно, это наш Main, потому что аннотация @SpringBootApplication помечена искомой).
                            2. Далее происходит поиск бинов, сервисов и других конфигураций согласно @ComponentScan (да, эта аннотация тоже включена в @SpringBootApplication), спускаясь от этого класса.
                            3. Но не все бины будут созданы для теста. Тест содержит поле PersonRepository, помеченное @MockBean. Поэтому вместо реального репозитория, в PersonService придёт мок.
                            4. Ну и после поднятия контекста в @Autowired придёт созданный сервис.*/

//@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
                            //анатирует как спринговый тест и которому нужно развернуть веб  контекс
@AutoConfigureMockMvc      //спринг поднимает тестовый контекст в котором заглушками заткнуто отправка и получение http
@ContextConfiguration(classes = PermutationConfiguration.class)
                          //считывание бинов в контекс


class PermutationControllerTest {

    @LocalServerPort
    public int port; //автоматически засунеться порт на котором работаем мой сервис


    /*    RestTemplate -в первом параметре передается адрес URL, куда
                    должен быть отправлен ресурс, во втором параметре – отправляемый объект, в третьем – Java-тип объекта,
                    который, как ожидается, должен быть возвращен обратно. В версиях, которые принимают
                    URL в виде строки, четвертый параметр определяет значения переменных-заполнителей в шаблоне URL
                    (либо в виде списка аргументов переменной длины, либо в виде отображения Map).*/
    @Test
    void create() {
        ArrayList<Object> initialPermutation=new ArrayList<>(Arrays.asList( "Ford","BMW","Fiat"));
        RestTemplate restTemplate = new RestTemplate();  //это специальный клиент для отправки запросов в Spring.  // Он предоставляет удобные API для легкого вызова конечных точек REST’а в одну строку.
        String fooResourceUrl = "http://localhost:9090/createInitialPermutation";
        ResponseEntity<String> response = restTemplate.postForObject(fooResourceUrl,initialPermutation, ResponseEntity.class);

    }

    @Test
    void createMetric() {
        Long metric=78l;
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:9090/createMetric";
        ResponseEntity<String> response = restTemplate.postForObject(fooResourceUrl,metric, ResponseEntity.class);

    }
}