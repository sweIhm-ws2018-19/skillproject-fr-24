package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class KoloraturenTrainingIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("KoloraturenTrainingIntent"))
                && (status.toString().equals(SessionAttributeList.statusStimme)
                || status.toString().equals(SessionAttributeList.statusHilfe)
                || status.toString().equals(SessionAttributeList.statusIntervall));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusLaufe);
        sessionAttributes.replace(SessionAttributeList.isLaufCompleted, Boolean.TRUE);

        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();

        String preText = listContainer.getSampleTrainLauf();
        preText += " <break time=\"0.9s\"/> ";
        String musicText = "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/laeufe.mp3\"/>";
        String postText = " <break time=\"0.9s\"/> ";
        if (sessionAttributes.get(SessionAttributeList.isIntervallCompleted).toString().equalsIgnoreCase("true")) {
            postText += listContainer.getTrainIntervallAndLaufCompletedEnding();
        } else {
            postText += listContainer.getTrainIntervallNotCompletedEndingForLauf();
        }
        postText += " <break time=\"0.5s\"/> ";
        String output = preText + musicText + postText;

        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, output);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder().withSpeech(output).withShouldEndSession(false).build();
    }
}
