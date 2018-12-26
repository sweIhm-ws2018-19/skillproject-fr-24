package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import songbird.lists.SessionAttributeList;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class NoIntentHandlerTest {

    NoIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockHandlerInput = mock(HandlerInput.class);
    AttributesManager mockAttrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new NoIntentHandler();
        sessionAttributes = new HashMap<>();

        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttrManager);
        when(mockAttrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockHandlerInput.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandle() {
    }

    @Test
    public void testHandleStatusTipp() {
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusTipp);
    }

    @Test
    public void testHandleIntervallStatusTrue() {
        sessionAttributes.put(SessionAttributeList.lastIntent, "");
        sessionAttributes.put(SessionAttributeList.isIntervallCompleted, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.isLaufCompleted, Boolean.FALSE);
    }

    @Test
    public void testHandleLaufStatusTrue() {
        sessionAttributes.put(SessionAttributeList.lastIntent, "");
        sessionAttributes.put(SessionAttributeList.isIntervallCompleted, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.isLaufCompleted, Boolean.TRUE);
    }

    @Test
    public void testHandleInvalidNo() {
        sessionAttributes.put(SessionAttributeList.lastIntent, "");
        sessionAttributes.put(SessionAttributeList.isIntervallCompleted, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.isLaufCompleted, Boolean.FALSE);
    }
}