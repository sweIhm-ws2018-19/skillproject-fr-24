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

public class YesIntentHandlerTest {

    YesIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new YesIntentHandler();
        sessionAttributes = new HashMap<>();
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandle() {
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandleStatusTippIntervallLaufTrue() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_TIPP);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);

        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
    }

    @Test
    public void testHandleStatusIntervallLaufFalse() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_INTERVALL);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.TRUE);

        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
    }

    @Test
    public void testHandleStatusLaufIntervallFalse() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_LAUFE);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.TRUE);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);

        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
    }

    @Test
    public void testHandleRestError() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_STIMME);
        sessionAttributes.put(SessionAttributeList.IS_LAUF_COMPLETED, Boolean.FALSE);
        sessionAttributes.put(SessionAttributeList.IS_INTERVALL_COMPLETED, Boolean.FALSE);

        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
    }
}