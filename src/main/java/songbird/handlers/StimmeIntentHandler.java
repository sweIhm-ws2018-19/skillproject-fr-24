/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package java.songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.interfaces.audioplayer.AudioItem;
import com.amazon.ask.model.interfaces.audioplayer.AudioPlayerInterface;
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior;
import com.amazon.ask.model.interfaces.audioplayer.Stream;
import com.amazon.ask.response.ResponseBuilder;
import org.apache.http.client.methods.RequestBuilder;


import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StimmeIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("StimmeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;
        String trainingText;
        String path = "https://s3.amazonaws.com/songbirdswe/testaudio.mp3";

        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();

        Map<String, Slot> slots = intent.getSlots();
        String example = slots.get("BeispielZwerchfell").getValue();
        String trainingType = slots.get("Intervalle_Kolleraturen").getValue();

        if (slots.get("BeispielZwerchfell").toString().contains("True")) {
            speechText = "Spiele Beispiel ab";
        }
        else if(slots.get("BeispielZwerchfell").toString().contains("False")){
            speechText = "";
        }
        else {
            return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
        }

        if (slots.get("Intervalle_Kolleraturen").toString().contains("Intervalle")) {
            trainingText = "Los gehts. Zuerst spiele ich dir die Intervalle vor und du steigst ein. Audidatei_Intervall eins bis acht Shuffeln. Demoskill beendet";
        }
        else if (slots.get("Intervalle_Kolleraturen").toString().contains("Kolleraturen")) {
            trainingText = "Weiter gehts. Zuerst spiele ich dir die Koloraturen vor und du singst auf H mit. Spiele Audiodatei_Koloratur Eins Zwei und Drei ab. Demoskill beendet";
        }
        else {
            return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
        }

        boolean isEndOfDialog = intentRequest.getDialogState() == DialogState.COMPLETED;
        if(isEndOfDialog){
            return input.getResponseBuilder().withSpeech(trainingText).build();
        }
        //String example = (String)input.getAttributesManager().getSessionAttributes().get("BeispielZwerchfell");

        //AudioItem item = AudioItem.builder().build();
        //builder.addAudioPlayerPlayDirective(PlayBehavior.ENQUEUE, Long.valueOf(0), "",path ,path);
        return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
    }
    /*
    private void askForTrainingType(HandlerInput input) {
        String trainingType = (String)input.getAttributesManager().getSessionAttributes().get("Intervalle_Kolleraturen");
        if(trainingType.equals("Kolleraturen")) {
            //run audio file
        }
        else{
            //run audio file
        }
    }*/
}
