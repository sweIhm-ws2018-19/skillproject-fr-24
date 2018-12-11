package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class NoIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("AMAZON.NoIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        TippsIntentHandler tipHandler = new TippsIntentHandler();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        Object lastIntent = sessionAttributes.get(SessionAttributeList.lastIntent);
        Object intervallStatus = sessionAttributes.get(SessionAttributeList.isIntervallCompleted);
        Object laufStatus = sessionAttributes.get(SessionAttributeList.isLaufCompleted);

        if (lastIntent.toString().equals(SessionAttributeList.statusTipp)
                && (intervallStatus.toString().equalsIgnoreCase("true")
                || laufStatus.toString().equalsIgnoreCase("true"))) {
            return input.getResponseBuilder()
                    .withSpeech("Auf Wiedersehen")
                    .withShouldEndSession(true)
                    .build();
        } else if (intervallStatus.toString().equalsIgnoreCase("true")
                || laufStatus.toString().equalsIgnoreCase("true")) {
            return input.getResponseBuilder()
                    .withShouldEndSession(true)
                    .withSpeech("Auf Wiedersehen")
                    .build();
        } else {
            return input.getResponseBuilder()
                    .withSpeech("")
                    .withShouldEndSession(false).build();
        }





    }
}