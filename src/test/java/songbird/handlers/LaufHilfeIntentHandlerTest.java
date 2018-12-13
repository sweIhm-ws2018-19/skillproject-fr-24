package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import songbird.lists.SessionAttributeList;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LaufHilfeIntentHandlerTest {

    LaufHilfeIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp(){
        handler = new LaufHilfeIntentHandler();
        when(mockAtrManager.getPersistentAttributes()).thenReturn(new HashMap<>());
        when(mockAtrManager.getRequestAttributes()).thenReturn(new HashMap<>());
        sessionAttributes = new HashMap<>();
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusStimme);
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
    }

    @Test
    public void testCanHandle() {
        when(mockInputHandler.matches(any())).thenReturn(true);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        Assert.assertTrue(handler.canHandle(mockInputHandler));

    }

    @Test
    public void testHandle() {
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        Assert.assertFalse(handler.handle(mockInputHandler).toString().isEmpty());
        Assert.assertEquals(SessionAttributeList.statusHilfe, mockInputHandler.getAttributesManager().getSessionAttributes().get(SessionAttributeList.lastIntent));
    }
}