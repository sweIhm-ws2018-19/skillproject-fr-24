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
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;
import com.amazon.ask.response.ResponseBuilder;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StimmeIntentHandler implements RequestHandler {

    //public static int testVariable = 0;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("StimmeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();

        Map<String, Slot> slots = intent.getSlots();
        String example = slots.get("BeispielZwerchfell").getValue();

        //check if to play example or not
        if (slots.get("BeispielZwerchfell").toString().contains("True")) {
            speechText = "Spiele Beispiel ab";
            speechText += "Möchtest du jetzt Koloraturen oder Intervalle üben?";
        }
        else if(slots.get("BeispielZwerchfell").toString().contains("False")){
            speechText = "";
            speechText += "Möchtest du jetzt Koloraturen oder Intervalle üben?";
        }
        else {
            return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
        }

        return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
    }
}
