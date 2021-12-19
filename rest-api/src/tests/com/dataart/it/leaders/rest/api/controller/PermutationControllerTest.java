package tests.com.dataart.it.leaders.rest.api.controller;



import com.dataart.it.leaders.rest.api.controller.PermutationControllerTestConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

/*
        @ContextConfiguration-указывает, какие файл Config  содержит ApplicationContext. Анотация -одна из основных аннотаций загрузки Spring для загрузки контекста приложения:

         @SpringBootTest    -1. движок идёт по пакету вверх, пока не встретит класс, помеченный аннотацией @SpringBootConfiguration
 (как ни странно, это наш Main, потому что аннотация @SpringBootApplication помечена искомой).
2. Далее происходит поиск бинов, сервисов и других конфигураций согласно @ComponentScan (да, эта аннотация тоже включена в @SpringBootApplication), спускаясь от этого класса.
3. Но не все бины будут созданы для теста. Тест содержит поле PersonRepository, помеченное @MockBean. Поэтому вместо реального репозитория, в PersonService придёт мок.
4. Ну и после поднятия контекста в @Autowired придёт созданный сервис.

        RestTemplate -в первом параметре передается адрес URL, куда
 должен быть отправлен ресурс, во втором параметре – отправляемый объект, в третьем – Java-тип объекта,
который, как ожидается, должен быть возвращен обратно. В версиях, которые принимают
RL в виде строки, четвертый параметр определяет значения переменных-заполнителей в шаблоне URL
либо в виде списка аргументов переменной длины, либо в виде отображения Map)
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //анатирует как спринговый тест и которому нужно развернуть веб  контекс. Внимание на Randomport-он сам выберет свободный порт
@AutoConfigureMockMvc      //спринг поднимает тестовый контекст в котором заглушками заткнуто отправка и получение http
@ContextConfiguration(classes = PermutationControllerTestConfiguration.class)//считывание бинов в контекс

public class PermutationControllerTest {

    @LocalServerPort
    public int port; //автоматически засунеться порт ( randomport) на котором работает мой сервис

    //никакие моки (заглушки) ненужны ,так как тестируем реальный http запрос на контроллер


    /* у обьекта restTemplate нам нужен метод !postForEntity! т.к - метод getForObject() возвращает только ресурс (преобразованный в Java-объект с
    помощью преобразователя HTTP-сообщений), то метод getForEntity()возвращает тот же самый объект, помещенный внутрь объекта
    ResponseEntity. Объект ResponseEntity несет в себе также дополнительную информацию об ответе, такую как код состояния HTTP и заголовки ответа.*/
    @Test
    public void create() {
        ArrayList<Object> initialPermutation = new ArrayList<>(Arrays.asList("Ford", "BMW", "Fiat"));
        RestTemplate restTemplate = new RestTemplate();    //это специальный клиент для отправки запросов в Spring.  // Он предоставляет удобные API для легкого вызова конечных точек REST’а в одну строку.
        String fooResourceUrl = "http://localhost:"+port+"/createInitialPermutation";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, initialPermutation,String.class); //в параметрах адрес, передаваемый объект, тип возвращаемого значения
        Assert.assertTrue(response.getStatusCode()== HttpStatus.OK);  //метод проверки одного трушного условия. getStatusCode() Выдергивает код ответа из объекта response

        }

    @Test
    public void createMetric() {
        Long metric = 78l;
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:"+port+"/createInitialPermutation";
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, metric,String.class);
        Assert.assertTrue(response.getStatusCode()== HttpStatus.OK);
    }
}