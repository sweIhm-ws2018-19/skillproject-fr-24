package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TippsIntentHandler implements RequestHandler {


    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("TippsIntent"))
                && (status.toString().equals(SessionAttributeList.statusWelcome)
                || status.toString().equals(SessionAttributeList.statusIntervall)
                || status.toString().equals(SessionAttributeList.statusLaufe)
                || status.toString().equals(SessionAttributeList.statusTipp));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers tip = new ListContainers();
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        tip.setMap(sessionAttributes);

        Object intervallStatus = sessionAttributes.get(SessionAttributeList.isIntervallCompleted);
        Object laufStatus = sessionAttributes.get(SessionAttributeList.isLaufCompleted);
        String speechText = tip.getRandomTip();

        if (intervallStatus.toString().equalsIgnoreCase("true") || laufStatus.toString().equalsIgnoreCase("true")) {
            speechText += "  Brauchst du noch einen weiteren Tipp? ";
        } else {
            speechText += " Möchtest du jetzt an deiner Stimme arbeiten oder brauchst du noch einen weiteren Tipp?";
        }

        Map<String, Boolean> newTipmap = tip.getMap();

        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusTipp);
        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, speechText);
        sessionAttributes.replaceAll((k, v) -> newTipmap.containsKey(k) ? newTipmap.get(k) : v);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}

