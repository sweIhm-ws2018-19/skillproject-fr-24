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
    public Optional<Response> handle(HandlerInput handlerInput) {


        String tippsText = "test, Koloraturen";


        return handlerInput.getResponseBuilder().withSpeech(tippsText).withShouldEndSession(false).build();
    }
}

