package com.dataart.it.leaders.rest.api.service;

import java.util.List;
/**Сервис перестановки и метрики*/
public interface PermutationService {

    void createInitialPermutation(List<Object> initilPermutation);

    void createLowMetric(Long metric);

}
