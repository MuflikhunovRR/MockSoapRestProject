package ru.gotoqa.mock.core.storages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import ru.gotoqa.mock.entity.TCurrency;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class CountryCurrencyResponseStorage {

    @Getter
    private final Map<String, TCurrency> responseStorage = new HashMap<>();

    public void putInStorage(String countryISOCode, TCurrency tCurrency) {
        responseStorage.put(countryISOCode, tCurrency);
        log.info("Add CountryCurrency filter {} success", tCurrency);
    }

    public TCurrency getCountryCurrency(String isoCode) {
        log.info("Get CountryCurrency filter by ISOCode={}", isoCode);
        return responseStorage.get(isoCode);
    }

    public void clearResponseStorage() {
        responseStorage.clear();
        log.info("Clear all filters");
    }

    public void removeRuleById(String isoCode) {
        responseStorage.remove(isoCode);
        log.info("Clear CountryCurrency filters by countryISOCode");
    }
}
