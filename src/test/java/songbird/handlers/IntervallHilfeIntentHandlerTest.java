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


public class IntervallHilfeIntentHandlerTest {

    IntervallHilfeIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockHandlerInput = mock(HandlerInput.class);
    AttributesManager mockAttrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new IntervallHilfeIntentHandler();
        sessionAttributes = new HashMap<>();
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_STIMME);
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "");
        when(mockHandlerInput.getAttributesManager()).thenReturn(mockAttrManager);
        when(mockAttrManager.getSessionAttributes()).thenReturn(sessionAttributes);
    }

    @Test
    public void testCanHandle() {
        when(mockHandlerInput.matches(any())).thenReturn(true);

        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testHandle() {
        when(mockHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        String actual = handler.handle(mockHandlerInput).toString();
        String actualRepeatText = sessionAttributes.get(SessionAttributeList.FOR_REPEAT_INTENT).toString();

        Assert.assertEquals(SessionAttributeList.STATUS_HILFE, sessionAttributes.get(SessionAttributeList.LAST_INTENT));
        Assert.assertTrue(actual.contains("Als Intervall bezeichnet man ")
                || actual.contains("Intervalle sind"));
        Assert.assertTrue(actualRepeatText.contains("Als Intervall bezeichnet man")
        || actualRepeatText.contains("Intervalle sind"));
    }
}