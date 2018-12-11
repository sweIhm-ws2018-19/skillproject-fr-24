package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.SessionAttributeList;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class RepeatIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.RepeatIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Object repeatText = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.forRepeatIntent);
        String speechText = repeatText.toString();

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false).build();
    }
}
