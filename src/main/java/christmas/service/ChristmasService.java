package christmas.service;

import christmas.domain.ExpectedDate;
import christmas.repository.DomainRepository;

public class ChristmasService {

    private final DomainRepository domainRepository;

    public ChristmasService() {
        this.domainRepository = new DomainRepository();
    }

    public void saveExpectedDate(final ExpectedDate expectedDate) {
        domainRepository.saveExpectedDate(expectedDate);
    }
}
