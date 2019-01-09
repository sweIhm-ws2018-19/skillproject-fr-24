package songbird.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import songbird.lists.SessionAttributeList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TippsIntentHandlerTest {

    TippsIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new TippsIntentHandler();
        sessionAttributes = new HashMap<>();
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandleStatusWelcome() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_WELCOME);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testCanHandleStatusIntervall() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_INTERVALL);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testCanHandleStatusLauf() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_LAUFE);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testCanHandleStatusTipp() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_TIPP);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandleIntervallTrue() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "test");
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "test");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);

        Optional<Response> actual = handler.handle(mockInputHandler);

        Assert.assertFalse(actual.toString().isEmpty());
        Assert.assertFalse(mockAtrManager.getSessionAttributes().get(SessionAttributeList.FOR_REPEAT_INTENT).toString().isEmpty());
        Assert.assertEquals(SessionAttributeList.STATUS_TIPP, mockAtrManager.getSessionAttributes().get(SessionAttributeList.LAST_INTENT));
    }

    @Test
    public void testHandleLaufeTrue() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "");
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);

        Optional<Response> actual = handler.handle(mockInputHandler);


        Assert.assertFalse(actual.toString().isEmpty());
        Assert.assertFalse(mockAtrManager.getSessionAttributes().get(SessionAttributeList.FOR_REPEAT_INTENT).toString().isEmpty());
        Assert.assertEquals(SessionAttributeList.STATUS_TIPP, mockAtrManager.getSessionAttributes().get(SessionAttributeList.LAST_INTENT));
    }

    @Test
    public void testHandleIntervallLaufeFalse() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "");
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "");
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);

        Optional<Response> actual = handler.handle(mockInputHandler);

        Assert.assertFalse(actual.toString().isEmpty());
        Assert.assertFalse(mockAtrManager.getSessionAttributes().get(SessionAttributeList.FOR_REPEAT_INTENT).toString().isEmpty());
        Assert.assertEquals(SessionAttributeList.STATUS_TIPP, mockAtrManager.getSessionAttributes().get(SessionAttributeList.LAST_INTENT));
    }
}