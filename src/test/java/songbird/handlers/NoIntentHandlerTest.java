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
        Assert.assertTrue(handler.canHandle(mockHandlerInput));
    }

    @Test
    public void testHandleStatusTippStatusIntervall() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_TIPP);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(handler.handle(mockHandlerInput).get().getShouldEndSession());
    }

    @Test
    public void testHandleStatusTippStatusLauf() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_TIPP);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(handler.handle(mockHandlerInput).get().getShouldEndSession());
    }

    @Test
    public void testHandleIntervallStatusTrue() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(handler.handle(mockHandlerInput).get().getShouldEndSession());
    }

    @Test
    public void testHandleLaufStatusTrue() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(handler.handle(mockHandlerInput).get().getShouldEndSession());
    }

    @Test
    public void testHandleInvalidNo() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);

        String actual = handler.handle(mockHandlerInput).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertFalse(handler.handle(mockHandlerInput).get().getShouldEndSession());
    }
}