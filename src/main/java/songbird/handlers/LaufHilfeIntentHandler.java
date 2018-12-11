package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LaufHilfeIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("LaufHilfeIntent"))
                && status.toString().equals(SessionAttributeList.statusStimme);
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers help = new ListContainers();
        String speechText = help.getRandomExplanationForLauf();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusHilfe);
        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, speechText);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}