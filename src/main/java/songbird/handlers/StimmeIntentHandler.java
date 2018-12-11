/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StimmeIntentHandler implements RequestHandler {


    @Override
    public boolean canHandle(HandlerInput input) {
        Object status = input.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent);
        return input.matches(intentName("StimmeIntent"))
                && (status.toString().equals(SessionAttributeList.statusWelcome)
                || status.toString().equals(SessionAttributeList.statusTipp));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();

        String speechText = listContainer.getRandomWorkOnVoiceCommand();
        speechText += "<break time=\"1.0s\"/>";
        /*
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();

        Map<String, Slot> slots = intent.getSlots();
        String example = slots.get("BeispielZwerchfell").getValue();


        //check if to play example or not
        if (slots.get("BeispielZwerchfell").toString().contains("True")) {
            speechText = listContainer.getRandomExampleForZwerchfellWished();
            speechText += "<break time=\"0.9s\"/>. ";
            speechText += listContainer.getRandomQuestionIntervallOrLauf();
        } else if (slots.get("BeispielZwerchfell").toString().contains("False")) {
            speechText = listContainer.getRandomNoExampleForZwerchfellWished();
            speechText += "<break time=\"8.0s\"/>. ";
            speechText += listContainer.getRandomQuestionIntervallOrLauf();
        } else {
            return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
        }*/

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusStimme);
        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, speechText);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
    }
}
