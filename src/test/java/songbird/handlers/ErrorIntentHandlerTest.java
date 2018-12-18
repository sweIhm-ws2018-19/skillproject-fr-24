package songbird.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ErrorIntentHandlerTest {

    ErrorIntentHandler handler;

    @Mock
    HandlerInput mockInputHandler = mock(HandlerInput.class);

    @Before
    public void setup() {
        handler = new ErrorIntentHandler();

    }

    @Test
    public void testCanHandle() {
        Assert.assertTrue(handler.canHandle(mockInputHandler));
    }

    @Test
    public void testHandle() {
        when(mockInputHandler.getResponseBuilder()).thenReturn(new ResponseBuilder());
        String actual = handler.handle(mockInputHandler).toString();
        Assert.assertFalse(actual.isEmpty());
        Assert.assertTrue(actual.contains("Sieht so aus, als ob ein Fehler aufgetreten ist"));
    }
}