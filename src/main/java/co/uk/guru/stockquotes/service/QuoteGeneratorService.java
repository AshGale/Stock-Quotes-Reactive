package co.uk.guru.stockquotes.service;

import co.uk.guru.stockquotes.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * The interface Quote generator service.
 */
public interface QuoteGeneratorService {

    /**
     * Fetch quote stream flux.
     *
     * @param period the period
     * @return the flux
     */
    Flux<Quote> fetchQuoteStream(Duration period);
}
