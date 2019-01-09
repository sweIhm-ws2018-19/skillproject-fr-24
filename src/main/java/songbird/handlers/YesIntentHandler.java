package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


public class YesIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.YesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        IntervallTrainingIntentHandler intervallHandle = new IntervallTrainingIntentHandler();
        KoloraturenTrainingIntentHandler laufHandle = new KoloraturenTrainingIntentHandler();
        TippsIntentHandler tipHandler = new TippsIntentHandler();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        Object intervallStatus = sessionAttributes.get(SessionAttributeList.IS_INTERVALL_COMPLETED);
        Object laufStatus = sessionAttributes.get(SessionAttributeList.IS_LAUF_COMPLETED);
        Object lastIntent = sessionAttributes.get(SessionAttributeList.LAST_INTENT);

        if (lastIntent.toString().equals(SessionAttributeList.STATUS_TIPP) || (intervallStatus.toString().equalsIgnoreCase("true") && laufStatus.toString().equalsIgnoreCase("true"))) {
            return tipHandler.handle(input);
        } else if (lastIntent.toString().equals(SessionAttributeList.STATUS_INTERVALL) && laufStatus.toString().equalsIgnoreCase("false")) {
            return laufHandle.handle(input);
        } else if (lastIntent.toString().equals(SessionAttributeList.STATUS_LAUFE) && intervallStatus.toString().equalsIgnoreCase("false")) {
            return intervallHandle.handle(input);
        } else {

            return input.getResponseBuilder()
                    .withShouldEndSession(false)
                    .withSpeech("Fehler " + lastIntent.toString())
                    .build();
        }

    }
}
