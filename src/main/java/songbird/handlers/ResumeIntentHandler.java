package main.java.songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;



import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ResumeIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
            return input.matches(intentName("AMAZON.ResumeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return Optional.empty();
    }
}
