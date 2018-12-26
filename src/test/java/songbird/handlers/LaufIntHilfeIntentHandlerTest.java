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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LaufIntHilfeIntentHandlerTest {

    LaufIntHilfeIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockHandlerInput = mock(HandlerInput.class);
    AttributesManager mockAttrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new LaufIntHilfeIntentHandler();
        sessionAttributes = new HashMap<>();
        sessionAttributes.put(SessionAttributeList.lastIntent, SessionAttributeList.statusStimme);

        when(mockHandlerInput.matches(any())).thenReturn(true);
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttrManager);
        when(mockAttrManager.getSessionAttributes()).thenReturn(sessionAttributes);
    }

    @Test
    public void testCanHandle() {
        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testHandle() {
        sessionAttributes.put(SessionAttributeList.forRepeatIntent, "");

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertEquals(SessionAttributeList.statusHilfe, mockAttrManager.getSessionAttributes().get(SessionAttributeList.lastIntent).toString());
        Assert.assertFalse(mockAttrManager.getSessionAttributes().get(SessionAttributeList.forRepeatIntent).toString().isEmpty());
        Assert.assertTrue(actual.contains("Bei Intervallen geht es in der Musik")
                || actual.contains("zwischen zwei gleichzeitig oder nacheinander erklingenden"));
    }
}