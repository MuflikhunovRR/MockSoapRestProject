package ru.gotoqa.mock.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gotoqa.mock.core.storages.CountryCurrencyRequestStorage;
import ru.gotoqa.mock.core.storages.CountryCurrencyResponseStorage;
import ru.gotoqa.mock.entity.CountryCurrency;
import ru.gotoqa.mock.entity.TCurrency;

import java.util.List;

/**
 * Mock manager settings for CountryCurrency
 */
@Log4j2
@RestController
@RequestMapping("/filter/countryCurrency")
@Api(tags = "Mock manager settings for CountryCurrency")
public class CountryCurrencyFilterController {

    private final CountryCurrencyRequestStorage countryCurrencyRequestStorage;
    private final CountryCurrencyResponseStorage countryCurrencyResponseStorage;

    @Autowired
    public CountryCurrencyFilterController(CountryCurrencyRequestStorage countryCurrencyRequestStorage,
                                           CountryCurrencyResponseStorage countryCurrencyResponseStorage) {
        this.countryCurrencyRequestStorage = countryCurrencyRequestStorage;
        this.countryCurrencyResponseStorage = countryCurrencyResponseStorage;
    }

    @ApiOperation(value = "Add new rule CountryCurrencyResponse by countryISOCode")
    @PostMapping("/createRule")
    public void createRule(String code, @RequestBody TCurrency tCurrency) {
        countryCurrencyResponseStorage.putInStorage(code, tCurrency);
    }

    @ApiOperation(value = "Get all rules for CountryCurrencyResponse")
    @GetMapping("/showAllRulesCountryCurrencyResponse")
    public Object showAllCountryCurrencyResponse() {
        return countryCurrencyResponseStorage.getResponseStorage();
    }

    @ApiOperation(value = "Get all CountryCurrency requests from storage")
    @GetMapping("/showCountryCurrencyRequestStorage")
    public List<CountryCurrency> showCountryCurrencyRqStorage() {
        return countryCurrencyRequestStorage.getRequestList();
    }

    @ApiOperation(value = "Remove rules CountryCurrencyResponse by countryISOCode")
    @DeleteMapping("/clearStorageByCode/{countryISOCode}")
    public void clearStorageByCode(@PathVariable String countryISOCode) {
        countryCurrencyResponseStorage.removeRuleById(countryISOCode);
    }

    @ApiOperation(value = "Clear storage CountryCurrency (rules + requests)")
    @DeleteMapping("/clearStorage")
    public void clearStorage() {
        countryCurrencyRequestStorage.clearRequestStorage();
        countryCurrencyResponseStorage.clearResponseStorage();
    }

}