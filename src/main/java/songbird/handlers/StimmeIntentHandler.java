/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.java.songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StimmeIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("StimmeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText;

        speechText = "Super! Wir beginnen mit einer Aufwärmübung, um dein Zwerchfell zu trainieren. Atme tief in deinen Bauch ein und halte die Luft an für 3 Sekunden. Nun atme langsam auf den Konsonanten F aus. Möchtest du ein Beispiel dazu hören?";

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("SimpleCardExample", speechText)
                .build();
    }
}
