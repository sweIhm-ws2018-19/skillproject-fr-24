package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.audioplayer.*;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class KoloraturenTrainingIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("KoloraturenTrainingIntent"));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        String preText = "Weiter gehts. Zuerst spiele ich dir die Läufe vor und du singst auf <break time=\"0.2s\"/> H <break time=\"0.2s\"/> mit.";
        String musicText = "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Laeufe.mp3\"/>";
        String output = preText + musicText + "Willst du jetzt Intervalle trainieren oder weiter Intervalle trainieren";


        return input.getResponseBuilder().withSpeech(musicText).withShouldEndSession(false).build();
    }
}
