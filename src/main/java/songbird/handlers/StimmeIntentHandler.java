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
import com.amazon.ask.model.Response;
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

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.replace(SessionAttributeList.lastIntent, SessionAttributeList.statusStimme);
        sessionAttributes.replace(SessionAttributeList.forRepeatIntent, speechText);
        input.getAttributesManager().setSessionAttributes(sessionAttributes);

        return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
    }
}
