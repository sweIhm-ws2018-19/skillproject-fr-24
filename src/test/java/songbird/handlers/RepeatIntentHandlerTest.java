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

public class RepeatIntentHandlerTest {

    RepeatIntentHandler handler;
    Map<String, Object> sessionAttributes;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);
    AttributesManager mockAtrManager = mock(AttributesManager.class);

    @Before
    public void setUp() {
        handler = new RepeatIntentHandler();
        sessionAttributes = new HashMap<>();
        sessionAttributes.put(SessionAttributeList.FOR_REPEAT_INTENT, "test this stuff!");
        when(mockInputHandler.getAttributesManager()).thenReturn(mockAtrManager);
        when(mockAtrManager.getSessionAttributes()).thenReturn(sessionAttributes);
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
    }

    @Test
    public void testCanHandle() {
        when(mockInputHandler.matches(any())).thenReturn(true);
        Assert.assertTrue(handler.canHandle(mockInputHandler));

    }

    @Test
    public void testHandle() {
        Optional<Response> actualObj = handler.handle(mockInputHandler);
        Boolean actualPresent = actualObj.isPresent();

        Assert.assertTrue(actualPresent);
        Assert.assertTrue(actualObj.toString().contains("test"));
        Assert.assertFalse(actualObj.get().getShouldEndSession());
    }
}