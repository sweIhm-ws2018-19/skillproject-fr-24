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
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.LAST_INTENT);
        return input.matches(intentName("KoloraturenTrainingIntent"))
                && (status.toString().equals(SessionAttributeList.STATUS_STIMME)
                || status.toString().equals(SessionAttributeList.STATUS_HILFE)
                || status.toString().equals(SessionAttributeList.STATUS_INTERVALL));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_LAUFE);
        sessionAttributes.replace(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);

        String preText = listContainer.getSampleTrainLauf();
        preText += " <break time=\"0.9s\"/> ";
        String musicText = "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/laeufe.mp3\"/>";
        String postText = " <break time=\"0.9s\"/> ";
        if (sessionAttributes.get(SessionAttributeList.IS_INTERVALL_COMPLETED).toString().equalsIgnoreCase("true")) {
            postText += listContainer.getTrainIntervallAndLaufCompletedEnding();
        } else {
            postText += listContainer.getTrainIntervallNotCompletedEndingForLauf();
        }
        postText += " <break time=\"0.5s\"/> ";
        String output = preText + musicText + postText;

        sessionAttributes.replace(SessionAttributeList.FOR_REPEAT_INTENT, output);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder().withSpeech(output).withShouldEndSession(false).build();
    }
}
