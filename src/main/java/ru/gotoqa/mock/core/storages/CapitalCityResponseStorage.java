package ru.gotoqa.mock.core.storages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class CapitalCityResponseStorage {

    @Getter
    private final Map<String, String> responseStorage = new HashMap<>();

    public void putInStorage(String countryISOCode, String capitalCity) {
        responseStorage.put(countryISOCode, capitalCity);
        log.info("Add filter {} success", capitalCity);
    }

    public String getCity(String isoCode) {
        log.info("Get filter by ISOCode={}", isoCode);
        return responseStorage.get(isoCode);
    }

    public void clearResponseStorage() {
        responseStorage.clear();
        log.info("Clear all filters");
    }

    public void removeRuleById(String isoCode) {
        responseStorage.remove(isoCode);
        log.info("Clear filters by countryISOCode");
    }
}
