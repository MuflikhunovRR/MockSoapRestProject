package ru.gotoqa.mock.core.builders;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gotoqa.mock.core.storages.CapitalCityRequestStorage;
import ru.gotoqa.mock.core.storages.CapitalCityResponseStorage;
import ru.gotoqa.mock.entity.CapitalCity;
import ru.gotoqa.mock.entity.CapitalCityResponse;

@Log4j2
public class CapitalCityResponseBuilder {

    @Autowired
    public CapitalCityRequestStorage requestStorage;
    @Autowired
    public CapitalCityResponseStorage responseStorage;

    public CapitalCityResponse createCountryCurrencyResponse(CapitalCity capitalCityRequest) {
        log.info("Start generate CapitalCityResponse");
        CapitalCityResponse profileResult = new CapitalCityResponse();
        requestStorage.addRequestToStorage(capitalCityRequest);
        String city = responseStorage.getCity(capitalCityRequest.getSCountryISOCode());
        profileResult.setCapitalCityResult(city);
        log.info("Finish generate CapitalCityResponse response");
        return profileResult;
    }

}