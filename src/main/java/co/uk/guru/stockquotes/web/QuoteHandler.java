package co.uk.guru.stockquotes.web;

import co.uk.guru.stockquotes.model.Quote;
import co.uk.guru.stockquotes.service.QuoteGeneratorService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;


/**
 * The type Quote handler.
 */
@Component
public class QuoteHandler {

    private final QuoteGeneratorService quoteGeneratorService;

    /**
     * Instantiates a new Quote handler.
     *
     * @param quoteGeneratorService the quote generator service
     */
    public QuoteHandler(QuoteGeneratorService quoteGeneratorService) {
        this.quoteGeneratorService = quoteGeneratorService;
    }

    /**
     * Fetch quotes mono.
     *
     * @param serverRequest the server request
     * @return the mono
     */
    public Mono<ServerResponse> fetchQuotes(ServerRequest serverRequest) {
        int size = Integer.parseInt(serverRequest.queryParam("size").orElse("10"));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100))
                        .take(size), Quote.class);
    }

}
