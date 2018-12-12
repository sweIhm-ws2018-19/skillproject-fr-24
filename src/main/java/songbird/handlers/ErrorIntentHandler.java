package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class ErrorIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = " Sieht so aus, als ob ein Fehler aufgetreten ist. Versuche eine gueltige Eingabe. ";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withShouldEndSession(false)
                .build();
    }
}
