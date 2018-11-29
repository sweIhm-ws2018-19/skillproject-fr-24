package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import songbird.lists.TipList;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TippsIntentHandler implements RequestHandler{
    private TipList tip = new TipList();

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("TippsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        String speechText = tip.getRandomTip();
        speechText += " Möchtest du jetzt an deiner Stimme arbeiten oder mehr Tipps?";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}

