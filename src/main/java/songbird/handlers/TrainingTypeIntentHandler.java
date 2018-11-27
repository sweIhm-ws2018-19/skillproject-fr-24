package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TrainingTypeIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("TrainingTypeIntent"));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        String output = "";


        Map<String, Slot> slots = intent.getSlots();
        String trainingType = slots.get("TrainingTypeChoice").getValue();

        if (trainingType.contains("Intervalle")) {
            output = "Intervalle wurde gewählt.";
        }
        else output = "Koloraturen wurden gewählt";

        return input.getResponseBuilder().withSpeech(output).build();
    }
}
