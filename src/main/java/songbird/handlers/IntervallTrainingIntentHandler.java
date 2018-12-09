package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.IntervallList;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class IntervallTrainingIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("IntervallTrainingIntent"));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        IntervallList list = new IntervallList();
        String preText = "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. <break time=\"0.9s\"/>";
        String postText = "Möchtest du weiter Intervalle trainieren oder Läufe üben ? <break time=\"0.9s\"/>";
        String musicText = list.getRandomIntervall();
        String output = preText + musicText + postText;


        return input.getResponseBuilder().withSpeech(output).withShouldEndSession(false).build();
        //return input.getResponseBuilder().withSpeech(output).addAudioPlayerPlayDirective(directive.getPlayBehavior(), Long.valueOf(0), null, "test.mp3", path).build();
    }
}
