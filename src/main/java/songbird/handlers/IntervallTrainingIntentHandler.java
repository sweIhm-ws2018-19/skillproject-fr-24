package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class IntervallTrainingIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("IntervallTrainingIntent"))
                && (status.toString().equals(SessionAttributeList.statusStimme)
                || status.toString().equals(SessionAttributeList.statusHilfe)
                || status.toString().equals(SessionAttributeList.statusLaufe));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusIntervall);
        sessionAttributes.replace(SessionAttributeList.isIntervallCompleted, Boolean.TRUE);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        String preText = "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. <break time=\"0.9s\"/>";
        String postText = "<break time=\"1.0s\"/>. ";
        if (sessionAttributes.get(SessionAttributeList.isLaufCompleted).toString().equalsIgnoreCase("true")) {
            postText += listContainer.getTrainIntervallAndLaufCompletedEnding();
        } else {
            postText += listContainer.getTrainLaufNotCompletedEndingForIntervall();
        }
        postText +=  " <break time=\"0.9s\"/>";
        String musicText = listContainer.getRandomIntervall();
        String output = preText + musicText + postText;


        return input.getResponseBuilder().withSpeech(output).withShouldEndSession(false).build();
        //return input.getResponseBuilder().withSpeech(output).addAudioPlayerPlayDirective(directive.getPlayBehavior(), Long.valueOf(0), null, "test.mp3", path).build();
    }
}
