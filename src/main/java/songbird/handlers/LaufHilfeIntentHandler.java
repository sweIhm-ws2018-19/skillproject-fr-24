package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import songbird.lists.ListContainers;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LaufHilfeIntentHandler implements RequestHandler{


    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("LaufHilfeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers help = new ListContainers();
        String speechText = help.getRandomExplanationForLauf();

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}