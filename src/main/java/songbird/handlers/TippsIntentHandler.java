package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TippsIntentHandler implements RequestHandler{


    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("TippsIntent"))
                && (status.toString().equals(SessionAttributeList.statusWelcome)
                || status.toString().equals(SessionAttributeList.statusIntervall)
                || status.toString().equals(SessionAttributeList.statusLaufe));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusTipp);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        ListContainers tip = new ListContainers();
        String speechText = tip.getRandomTip();
        speechText += " Möchtest du jetzt an deiner Stimme arbeiten oder brauchst du noch einen weiteren Tipp?";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}

