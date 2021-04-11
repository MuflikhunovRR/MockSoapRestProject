package ru.gotoqa.mock.core.storages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import ru.gotoqa.mock.entity.CapitalCity;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CapitalCityRequestStorage {
    /**
     * Storage for CapitalCity request
     */
    @Getter
    @Setter
    private List<CapitalCity> requestList = new ArrayList<>();

    public void addRequestToStorage(CapitalCity request) {
        requestList.add(request);
    }

    public void clearRequestStorage() {
        requestList.clear();
        log.info("Clear all CapitalCity filters");
    }

}