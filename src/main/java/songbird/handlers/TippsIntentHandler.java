package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TippsIntentHandler implements RequestHandler{
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.TippsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {


        String tippsText = "test, Koloraturen";


        return input.getResponseBuilder()
                .withSimpleCard("title", "cardText")
                .withSpeech(tippsText)
                .withReprompt("bar")
                .withShouldEndSession(false).build();
    }
}

