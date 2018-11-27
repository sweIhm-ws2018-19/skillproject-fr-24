package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.interfaces.audioplayer.*;

import java.io.FileInputStream;
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
        String path = "https://s3.amazonaws.com/songbirdswe/testaudio.mp3";

        Stream audioStream = Stream.builder().withUrl(path).withToken("test.mp3").withOffsetInMilliseconds(Long.valueOf(0)).build();
        AudioItem item = AudioItem.builder().withStream(audioStream).build();
        AudioPlayerState state = AudioPlayerState.builder().withToken("test.mp3").withPlayerActivity(PlayerActivity.PLAYING).build();
        PlayDirective directive = PlayDirective.builder().withAudioItem(item).build();

        Map<String, Slot> slots = intent.getSlots();
        String trainingType = slots.get("TrainingTypeChoice").getValue();

        if (trainingType.contains("Intervalle")) {
            output = "Intervalle wurde gewählt.";
        }
        else{
            output = "Koloraturen wurden gewählt";
        }

        return input.getResponseBuilder().withSpeech(output).addAudioPlayerPlayDirective(directive.getPlayBehavior(), Long.valueOf(0), null, "test.mp3", path).build();
    }
}
