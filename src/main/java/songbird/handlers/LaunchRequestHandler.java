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
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import songbird.lists.ListContainers;
import songbird.lists.SessionAttributeList;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        ListContainers listContainer = new ListContainers();
        String speechText = "<audio src='soundbank://soundlibrary/animals/amzn_sfx_bird_chickadee_chirp_1x_01'/>"
                + "<break time=\"400ms\"/>  "
                + listContainer.getRandomWelcomeMessage();

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_WELCOME);
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, speechText);
        sessionAttributes.putAll(listContainer.getMap());
        input.getAttributesManager().setRequestAttributes(sessionAttributes);

        String repromptText = "Ich kann dich leider nicht hören.";
        return input.getResponseBuilder()
                .withSimpleCard("WelcomeMessage", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
