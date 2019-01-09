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

public class WeiterExampleIntentHandlerTest {

    WeiterExampleIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new WeiterExampleIntentHandler();
        sessionAttributes = new HashMap<>();
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(mockInputHandler.matches(any())).thenReturn(true);
    }

    @Test
    public void testCanHandle() {
        sessionAttributes.put(SessionAttributeList.LAST_INTENT, SessionAttributeList.STATUS_STIMME);
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "");
        Optional<Response> actual = handler.handle(mockInputHandler);
        Assert.assertFalse(actual.toString().isEmpty());
        Assert.assertFalse(mockAtrManager.getSessionAttributes().get(SessionAttributeList.FOR_REPEAT_INTENT).toString().isEmpty());
    }
}