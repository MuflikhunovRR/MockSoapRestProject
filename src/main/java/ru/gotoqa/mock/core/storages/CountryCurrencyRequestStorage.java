package ru.gotoqa.mock.core.storages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import ru.gotoqa.mock.entity.CountryCurrency;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CountryCurrencyRequestStorage {
    /**
     * Storage for CountryCurrency request
     */
    @Getter
    @Setter
    private List<CountryCurrency> requestList = new ArrayList<>();

    public void addRequestToStorage(CountryCurrency request) {
        requestList.add(request);
    }

    public void clearRequestStorage() {
        requestList.clear();
        log.info("Clear all CountryCurrency filters");
    }

}