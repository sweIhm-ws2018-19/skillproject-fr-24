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

public class StimmeIntentHandlerTest {

    StimmeIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new StimmeIntentHandler();
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
    public void testCanHandleStatusTipp() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_TIPP);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, "dummy");
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "");
        Optional<Response> actual = handler.handle(mockInputHandler);

        Assert.assertTrue(actual.isPresent());
        Assert.assertFalse(actual.toString().isEmpty());
        Assert.assertEquals(SessionAttributeList.STATUS_STIMME, mockAtrManager.getSessionAttributes().get(SessionAttributeList.LAST_INTENT));
        Assert.assertFalse(mockAtrManager.getSessionAttributes().get(SessionAttributeList.FOR_REPEAT_INTENT).toString().isEmpty());
    }
}