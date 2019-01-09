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
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.LAST_INTENT);
        return input.matches(intentName("IntervallTrainingIntent"))
                && (status.toString().equals(SessionAttributeList.STATUS_STIMME)
                || status.toString().equals(SessionAttributeList.STATUS_HILFE)
                || status.toString().equals(SessionAttributeList.STATUS_LAUFE));
    }


    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_INTERVALL);
        sessionAttributes.replace(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);

        String preText = "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. <break time=\"0.8s\"/>";
        String postText = "<break time=\"1.0s\"/> ";
        if (sessionAttributes.get(SessionAttributeList.IS_LAUF_COMPLETED).toString().equalsIgnoreCase("true")) {
            postText += listContainer.getTrainIntervallAndLaufCompletedEnding();
        } else {
            postText += listContainer.getTrainLaufNotCompletedEndingForIntervall();
        }
        postText +=  " <break time=\"0.5s\"/>";
        String musicText = listContainer.getRandomIntervall();
        String output = preText + musicText + postText;

        sessionAttributes.replace(SessionAttributeList.FOR_REPEAT_INTENT, output);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder().withSpeech(output).withShouldEndSession(false).build();
    }
}
