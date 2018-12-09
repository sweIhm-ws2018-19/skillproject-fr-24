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
import com.amazon.ask.model.ui.SsmlOutputSpeech;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class AudioTestHandler implements RequestHandler {

    //public static int testVariable = 0;

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AudioTestHandler"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Laeufe.mp3\"/>";
        //String speechText = "<audio src=\"https://s3-us-west-1.amazonaws.com/sayspring-prod/media/celtic-open-chime.mp3\"/>";
        //String speechText = "<audio src=\"https://s3.amazonaws.com/songbirdswe/testaudio.mp3\"/>";
        //String musicText = "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Laeufe.mp3\"/>";
        String path = "https://s3.amazonaws.com/songbirdswe/testaudio.mp3";


        /*
        Stream audioStream = Stream.builder().withUrl(path).withToken("0000").withOffsetInMilliseconds(Long.valueOf(0)).build();
        AudioItem item = AudioItem.builder().withStream(audioStream).build();
        AudioPlayerState state = AudioPlayerState.builder().withToken("0000").withPlayerActivity(PlayerActivity.PLAYING).build();
        PlayDirective directive = PlayDirective.builder().withAudioItem(item).build();
        */


        //return input.getResponseBuilder().addAudioPlayerPlayDirective(PlayBehavior.REPLACE_ALL,state.getOffsetInMilliseconds(), null, state.getToken(),item.getStream().getUrl()).withShouldEndSession(false).build();
        return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
    }
}
