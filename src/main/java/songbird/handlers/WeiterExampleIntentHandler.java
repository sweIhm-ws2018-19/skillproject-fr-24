package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class WeiterExampleIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("WeiterExampleIntent"))
                && status.toString().equals(SessionAttributeList.statusStimme);
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        String speechText = listContainer.getRandomQuestionIntervallOrLauf();
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, speechText);

        return input.getResponseBuilder()
                .withShouldEndSession(false)
                .withSpeech(speechText)
                .build();
    }
}
